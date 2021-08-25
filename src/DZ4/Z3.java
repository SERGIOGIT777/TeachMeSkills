package DZ4;

import java.util.Random;

public class Z3 {
    public static void main(String[] args) {
        var mass = new int[5][5];
        var number = new Random();
        var chet = 1;
        var chet1 = 1;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                mass[i][j] = number.nextInt(10);
                System.out.print(mass[i][j] + " ");
                if (i == j) {
                    chet *= mass[i][j];
                }
                if ((i + j) == mass.length - 1) {
                    chet1 *= mass[i][j];
                }
            }
            System.out.println();
        }
        if (chet > chet1) {
            System.out.println("Произведение элементов главной диагонали больше");
        } else if (chet < chet1) {
            System.out.println("Произведение элементов побочной диагонали больше");
        } else {
            System.out.println("Произведение элементов диагоналей равны");
        }
    }
}
