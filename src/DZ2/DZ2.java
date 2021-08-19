package DZ2;

import java.util.Scanner;

public class DZ2 {
    public static void main(String[] args) {
        System.out.println("Выберите номер задачи:");
        var a = new Scanner(System.in).nextInt();
        switch (a) {
            case 1 -> z1();
            case 2 -> z2();
            case 3 -> z3();
            case 4 -> z4();
            case 5 -> z5();
            case 6 -> z6();
            case 7 -> z7();
            case 8 -> {
                System.out.println("Какую фигуру рисовать\n1. Два треугольника\n2. Ромб");
                var b = new Scanner(System.in).nextInt();
                switch (b){
                    case 1 -> z8();
                    case 2 -> z9();
                }
            }
            default -> System.err.println("Error!!!");
        }
    }

    static void z1() {
        float a = 10;
        for (int i = 0; i < 7; i++) {
            a = (float) ((a * 0.1) + a);
        }
        System.out.println("Summ = " + a);
    }

    static void z2() {
        int a = 1;
        for (int i = 3; i < 25; i = i + 3) {
            a = 2 * a;
            System.out.printf("Через %d час.  - %d амеб", i, a);
            System.out.println();
        }
    }

    static void z3() {
        int sum = 0;
        int a = 1;
        while (a <= 256) {
            sum += a;
            a *= 2;
        }
        System.out.println("Summ = " + sum);
    }

    static void z4() {
        System.out.println("Number a = ");
        var a = new Scanner(System.in).nextInt();
        System.out.println("Number b = ");
        var b = new Scanner(System.in).nextInt();
        int oper = 0;

        for (int i = 1; i <= b; i++) {
            oper += a;
        }
        System.out.println("a * b = " + oper);
    }

    static void z5() {
        double a = 2.54;
        for (int i = 1; i < 21; i++) {
            a *= i;
            System.out.printf("%d д. = %.2f сант.", i, a);
            System.out.println();
            a = 2.54;
        }
    }

    static void z6() {
        System.out.println("Четный числа в интервале 2 .. 100");
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.printf("%d, ", i);
            }
        }
    }

    static void z7() {
        int a = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {
                a += i;
            }
        }
        System.out.println("Сумма нечетных чисел в интервале 1 .. 99 = " + a);
    }

    static void z8() {
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j > i + 1; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i + 1; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j > i; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i + 1; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    static void z9() {
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j > i + 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
