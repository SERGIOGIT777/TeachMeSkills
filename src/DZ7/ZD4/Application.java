package DZ7.ZD4;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Application {
    public static void main(String[] args) throws IOException {
        var inputStream = "./src/DZ6/ZD4/input.txt";
        var outputStream = "./src/DZ6/ZD4/output.txt";
        var outputPoli = "./src/DZ6/ZD4/outputPoli.txt";
        readFile(inputStream, "utf-8");
        String s = readUsingFiles(inputStream);
        var textFormatter = new TextFormatter();
        var textImport = "";
        var tempS = s.split("\\.");
        for (int i = 0; i < tempS.length; i++) {
            var tempSS = tempS[i];
            if (textFormatter.inputString(tempSS) >= 3 && textFormatter.inputString(tempSS) <= 5
                && !(Objects.equals(textFormatter.polimorfInput(tempSS), "true"))) {
                textImport = tempSS;
                PrintWriter writer = new PrintWriter(outputStream, "UTF-8");
                writer.println(textImport);
                writer.close();
                textImport.replace(textImport, "");
            }
            if (Objects.equals(textFormatter.polimorfInput(tempSS), "true")) {
                textImport = tempSS;
                PrintWriter writer = new PrintWriter(outputPoli, "UTF-8");
                writer.println(textImport);
                writer.close();
                textImport.replace(textImport, "");
            }
        }
    }

    private static void readFile(String fileName, String charset) {
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charset));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
