package Test;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConfModification {

    public enum ModificationType {
        ADD_NEW,
        MODIFY_EXISTING,
        COMMENT_EXISTING,
        REMOVE
    }
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/mihir/Downloads/openssl.cnf";
        //method1(filePath);
        //method2(filePath);
        //List<String> sectionProperties = getConfigSection(filePath, "default_sect");
        //sectionProperties.stream().forEach(System.out::println);
        //List<String> updatedProperties = addSectionProperty(sectionProperties, "dummy_property", "dummy_value2");
        //System.out.println("-----------------------------------------------------------------");
        //writeNewPropertyIntoConfigSection(filePath, "default_sect", "dummy_property", "dummy_value3");
        //System.out.println("-----------------------------------------------------------------");
        //getConfigSection(filePath, "default_sect").stream().forEach(System.out::println);
        updateExistingPropertyIntoConfigSection(filePath, "default_sect", "mproperty2", "mvalue2", ModificationType.ADD_NEW);
    }

    public static void method1(String filePath){
        try {
            // Load the INI file
            Configurations configs = new Configurations();
            INIConfiguration config = configs.ini(new File(filePath));

            // Modify values
            config.setProperty("general.key1", "newValue1");
            config.setProperty("provider_sect.provider_key1", "newProviderValue1");

            // Write back to the file using a Writer
            try (Writer writer = new FileWriter(filePath)) {
                config.write(writer);
            }

            System.out.println("INI configuration file updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method2(String filePath) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<String> updatedLines = new ArrayList<>();

        String currentSection = "";
        for (String line : lines) {
            String trimmedLine = line.trim();

            // Preserve comments and empty lines
            if (trimmedLine.isEmpty() || trimmedLine.startsWith("#") || trimmedLine.startsWith(";")) {
                updatedLines.add(line);
                continue;
            }

            // Check for section headers
            if (trimmedLine.startsWith("[") && trimmedLine.endsWith("]")) {
                currentSection = trimmedLine.substring(1, trimmedLine.length() - 1);
                updatedLines.add(line);
                continue;
            }

            // Modify values based on section and key
            if (currentSection.equals("general") && trimmedLine.startsWith("key1")) {
                updatedLines.add("key1 = newValue1");
            } else {
                updatedLines.add(line); // Keep the line unchanged
            }
        }

        // Write back to the file
        Files.write(Paths.get(filePath), updatedLines);
        System.out.println("INI configuration file updated successfully.");
    }

    public static List<String> getConfigSection(String filePath, String sectionName) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<String> sectionProperties = new ArrayList<>();

        String currentSection = "";
        for (String line : lines) {
            String trimmedLine = line.trim();

            // Preserve comments and empty lines
            if (trimmedLine.isEmpty() || trimmedLine.startsWith("#") || trimmedLine.startsWith(";") || trimmedLine.startsWith(".")) {
                currentSection = "";
                continue;
            }

            // Check for section headers
            if (trimmedLine.startsWith("[") && trimmedLine.endsWith("]")) {
                currentSection = trimmedLine.substring(1, trimmedLine.length() - 1);
                continue;
            }

            // get section properties based on section
            if (currentSection.equals(sectionName)){
                sectionProperties.add(trimmedLine);
            }
        }

        return sectionProperties;
    }
    public static void writeNewPropertyIntoConfigSection(String filePath, String sectionName, String property, String value) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<String> updatedLines = new ArrayList<>();
        boolean isRequiredToWrite = true;

        String currentSection = "";
        for (String line : lines) {
            String trimmedLine = line.trim();

            // Preserve comments and empty lines
            if (trimmedLine.isEmpty() || trimmedLine.startsWith("#") || trimmedLine.startsWith(";")) {
                updatedLines.add(line);
                continue;
            }

            // Check for section headers
            if (trimmedLine.startsWith("[") && trimmedLine.endsWith("]")) {
                currentSection = trimmedLine.substring(1, trimmedLine.length() - 1);
                updatedLines.add(line);
                continue;
            }

            // Modify section with updated properties
            if(currentSection.equals(sectionName) && isRequiredToWrite){
                updatedLines.add(property.concat(" = ").concat(value));
                isRequiredToWrite = false;  // disable writer once written
            }

            updatedLines.add(line); // Keep the line unchanged
        }


        // Write back to the file
        Files.write(Paths.get(filePath), updatedLines);
        System.out.println("configuration file updated successfully.");
    }

    public static List<String> addSectionProperty(List<String> existingSectionProperties, String property, String value) {
        List<String> updatedProperties = new ArrayList<>();
        boolean isNewProperty = true;
        for (String existingProperty : existingSectionProperties){
            if (existingProperty.startsWith(property)) {
                updatedProperties.add(property.concat(" = ").concat(value));
                isNewProperty = false;
            } else {
                updatedProperties.add(existingProperty);
            }
        }

        if (isNewProperty) {
            updatedProperties.add(property.concat(" = ").concat(value));
        }

        return updatedProperties;
    }

    public static List<String> removeSectionProperty(List<String> existingSectionProperties, String property, String value) {
        List<String> updatedProperties = new ArrayList<>();

        for (String existingProperty : existingSectionProperties){
            if (!existingProperty.startsWith(property)) {
                updatedProperties.add(existingProperty);
            }
        }

        return updatedProperties;
    }

    public static void updateExistingPropertyIntoConfigSection(String filePath, String sectionName, String property, String value, ModificationType modificationType) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<String> updatedLines = new ArrayList<>();
        boolean isRequiredToWrite = true;

        String currentSection = "";
        for (String line : lines) {
            String trimmedLine = line.trim();

            // Preserve comments and empty lines
            if (trimmedLine.isEmpty() || trimmedLine.startsWith("#") || trimmedLine.startsWith(";")) {
                updatedLines.add(line);
                continue;
            }

            // Check for section headers
            if (trimmedLine.startsWith("[") && trimmedLine.endsWith("]")) {
                currentSection = trimmedLine.substring(1, trimmedLine.length() - 1);
                updatedLines.add(line);
                continue;
            }

            // Modify values based on section and property
            if(currentSection.equals(sectionName) && isRequiredToWrite){
                if(modificationType == ModificationType.ADD_NEW){
                    updatedLines.add(property.concat(" = ").concat(value));
                    updatedLines.add(line);
                } else if (modificationType == ModificationType.MODIFY_EXISTING && trimmedLine.startsWith(property)) {
                    updatedLines.add(property.concat(" = ").concat(value));
                } else if (modificationType == ModificationType.COMMENT_EXISTING && trimmedLine.startsWith(property)) {
                    updatedLines.add("#".concat(property).concat(" = ").concat(value));
                } else if (modificationType == ModificationType.REMOVE && trimmedLine.startsWith(property)) {
                    System.out.println("removed property");
                }
                isRequiredToWrite = false;  // disable writer once written
            } else {
                updatedLines.add(line); // Keep the line unchanged
            }
        }

        // Write back to the file
        Files.write(Paths.get(filePath), updatedLines);
        System.out.println("configuration file updated successfully.");
    }
}
