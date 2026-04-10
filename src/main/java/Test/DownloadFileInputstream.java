package Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

public class DownloadFileInputstream {

    public static void downloadAndReadFile(String fileUrl) throws IOException {
        // Open connection to the URL
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Check response code
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to download file: HTTP response code " + responseCode);
        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        connection.getInputStream().transferTo(buffer);
        byte[] data = buffer.toByteArray();

        /*try(InputStream clonedStream = new ByteArrayInputStream(data)) {
            if (isGzipStream(clonedStream)) {
                try (GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(data));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(gzipInputStream))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            } else {
                System.err.println("The file is not in GZIP format.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        } */

        System.out.println(isGzipStream3(new ByteArrayInputStream(data)) ? "GZIP" : "Not GZIP");

        // Get input stream from the connection
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            // Read and process the input stream
            readInputStream(new GZIPInputStream(new BufferedInputStream(inputStream)));
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
    }

    private static boolean isGzipStream(InputStream is)  {
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            bis.mark(2); // Mark the current position in the stream
            int magic1 = bis.read();
            int magic2 = bis.read();
            bis.reset(); // Reset the stream to the marked position
            return magic1 == 0x1F && magic2 == 0x8B; // Check for GZIP magic number
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private static void readInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Process each line
                if(i== 10){
                    break; // Limit to 10 lines for demonstration
                }
                i++;
            }
        }
    }

    private static boolean isGzipStream2(InputStream inputStream) {
        try (GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
            return true; // Successfully created GZIPInputStream, so it's GZIP format
        } catch (ZipException e) {
            return false; // Not in GZIP format
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Handle other IO exceptions
        }
    }

    public static boolean isGzipStream3(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream); // Wrap with BufferedInputStream
        }
        inputStream.mark(2); // Mark the first two bytes
        byte[] signature = new byte[2];
        int read = inputStream.read(signature); // Read the first two bytes
        inputStream.reset(); // Reset the stream to the marked position
        return read == 2 && (signature[0] == (byte) 0x1F && signature[1] == (byte) 0x8B); // GZIP magic number
    }

    public static void main(String[] args) {
        String urlart = "https://artifactory-ha.lab.redseal.net:443/artifactory/libs-release-local/mrana-trl/trl-LATEST-10.1.xml.gz";
        String fileUrl = "https://artifactory-ha.lab.redseal.net/ui/native/libs-release-local/mrana-trl/trl-LATEST-10.1.xml.gz"; // Replace with your URL
        try {
            downloadAndReadFile(urlart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
