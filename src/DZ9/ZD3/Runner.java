package DZ9.ZD3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        var fileBlack = "./src/DZ9/ZD3/blackList.txt";
        var count = 0;
        System.out.println("Выберите проверку предложения цифрой\n1 - без цензуры\n2 - с цензурой");
        var number = new Scanner(System.in).nextInt();
        switch (number) {
            case 1 -> {
                var fileInput = "./src/DZ9/ZD3/text1.txt";
                readFile(fileInput, "UTF-8");
                var offers = readUsingFiles(fileInput);
                var offers1 = readUsingFiles(fileBlack);
                var text = new textExamenetion();
                var temp = offers.split("\\. ");
                var temp1 = offers1.split("\\n");
                for (int i = 0; i < temp.length; i++) {
                    var temps = temp[i];
                    for (int j = 0; j < temp1.length; j++) {
                        var temps1 = temp1[j];
                        if (text.textExam(temps, temps1) > 0) {
                            count++;
                            System.out.println(temps);
                        }
                    }
                }
                if (count > 0) {
                    System.err.printf("Количество предложений, не прошедших проверку - %d\n", count);
                } else {
                    System.out.println("Текст прошел проверку на цензуру");
                }
            }
            case 2 -> {
                var fileInput = "./src/DZ9/ZD3/text2.txt";
                readFile(fileInput, "UTF-8");
                var offers = readUsingFiles(fileInput);
                var offers1 = readUsingFiles(fileBlack);
                var text = new textExamenetion();
                var temp = offers.split("\\. ");
                var temp1 = offers1.split("\\n");
                for (int i = 0; i < temp.length; i++) {
                    var temps = temp[i];
                    for (int j = 0; j < temp1.length; j++) {
                        var temps1 = temp1[j];
                        if (text.textExam(temps, temps1) > 0) {
                            count++;
                            System.out.println(temps);
                        }
                    }
                }
                if (count > 0) {
                    System.err.printf("Количество предложений, не прошедших проверку - %d\n", count);
                } else {
                    System.out.println("Текст прошел проверку на цензуру");
                }
            }
            default -> System.err.println("Не верный идентификатор");
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
