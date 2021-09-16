package DZ9.ZD2;

import DZ7.ZD4.TextFormatter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Run {
    public static void main(String[] args) throws IOException {
        var inputStream = "./src/DZ9/ZD2/input.txt";
        var outputStream = "./src/DZ9/ZD2/output.txt";
        readFile(inputStream, "UTF-8");
        var s = readUsingFiles(inputStream);
        var textFormatter = new TextFormatter();
        var textImport = "";
        var temp = s.split("\\. ");
        for (int i = 0; i < temp.length; i++) {
            var temps = temp[i];
            if (textFormatter.inputString(temps) >= 3 && textFormatter.inputString(temps) <= 5
                    && !(Objects.equals(textFormatter.polimorfInput(temps), "true"))) {
                textImport = temps;
                FileWriter writer = new FileWriter(outputStream, true);
                writer.write(textImport);
                writer.write('\n');
                writer.flush();
            }

            if (Objects.equals(textFormatter.polimorfInput(temps), "true")) {
                textImport = temps;
                FileWriter writer = new FileWriter(outputStream, true);
                writer.write(textImport);
                writer.flush();
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
