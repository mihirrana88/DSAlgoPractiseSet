package Test;

import java.util.regex.Pattern;

public class MatchCatAndDog {
    public static void main(String[] args) {
        // Regex to match strings containing both "cat" and "dog"
        String regex = "(?s)(?=.*^(\\*GRS>))(?=.*Version: HiOS)";
        String input1 = "*GRS> I have a cat and" +
                "\n a dog Version: HiOS.";
        String input2 = "*GRS> I have a cat.";
        String input3 = "I have a Version: HiOS.";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Test the inputs
        System.out.println("Input 1 matches: " + pattern.matcher(input1).find()); // true
        System.out.println("Input 2 matches: " + pattern.matcher(input2).find()); // false
        System.out.println("Input 3 matches: " + pattern.matcher(input3).find()); // false
    }
}
