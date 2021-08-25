package DZ4;

import java.util.Random;
import java.util.Scanner;

public class Z2 {
    public static void main(String[] args) {
        System.out.println("Введите размер матрицы");
        var a = new Scanner(System.in).nextInt();
        var b = new Scanner(System.in).nextInt();
        var mass = new int[a][b];
        var number = new Random();
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                mass[i][j] = number.nextInt(50);
                System.out.printf("%d\t", mass[i][j]);
            }
            System.out.println();
        }
        System.out.println("Нечетные элементы под главной диагональю (включительно):");
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (i == j + 1) {
                    if (mass[i][j] % 2 != 0) {
                        System.out.print(mass[i][j] + " ");
                    }
                }
            }
        }
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (i == j) {
                    if (mass[i][j] % 2 != 0) {
                        System.out.print(mass[i][j] + " ");
                    }
                }
            }
        }
    }
}
