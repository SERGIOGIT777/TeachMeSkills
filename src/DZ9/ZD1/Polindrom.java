package DZ9.ZD1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Polindrom {
    public static void main(String[] args) {
        try (FileReader polindrom = new FileReader("./src/DZ9/ZD1/text.txt");
             BufferedReader bf = new BufferedReader(polindrom);
             FileWriter fw = new FileWriter("./src/DZ9/ZD1/outputText.txt")) {
            var line = bf.readLine();
            while (line != null) {
                var word = new StringBuilder(line);
                if (word.reverse().toString().equals(line)) {
                    fw.write(String.valueOf(word));
                    fw.append('\n');
                    fw.flush();
                }
                line = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
