package DZ4;

import java.util.Random;

public class Z4 {
    public static void main(String[] args) {
        var mass = new int[5][5];
        var number = new Random();
        var chet = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                mass[i][j] = number.nextInt(10);
                System.out.print(mass[i][j] + " ");
                if ((i + j) == mass.length-2 && i != 0 && j != 0) {
                    if (mass[i][j] % 2 == 0) {
                        chet += mass[i][j];
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\nСумма четных элементов над побочной диагональю = " + chet);
    }
}
