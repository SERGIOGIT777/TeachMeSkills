package DZ4;

import java.util.Random;

public class Z5 {
    public static void main(String[] args) {
        var mass = new int[5][5];
        var number = new Random();
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                mass[i][j] = number.nextInt(10);
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Транспонированная матрица");
        for (int i = 0; i < mass.length; i++) {
            for (int j = mass.length - 1; j >= 0; j--) {
                System.out.print(mass[j][i] + " ");
            }
            System.out.println();
        }
    }
}
