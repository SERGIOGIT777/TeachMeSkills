package DZ3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DZ3 {
    public static void main(String[] args) {
        System.out.println("Выберите номер задачи!");
        var a = new Scanner(System.in).nextInt();
        switch (a) {
            case 1 -> z1();
            case 2 -> z2();
            case 3 -> z3();
            case 4 -> z4();
            case 5 -> z5();
            case 6 -> z6();
            case 7 -> z7();
            default -> System.err.println("Номера такой задачи нет");
        }
    }

    static void z1() {
        var mass = new int[21];
        var a = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                mass[a] = i;
                System.out.print(mass[a] + " ");
            }
        }
        System.out.println();
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                mass[a] = i;
                System.out.println(mass[a]);
            }
        }
    }

    static void z2() {
        var mass = new int[101];
        var a = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                mass[a] = i;
                System.out.print(mass[a] + " ");
            }
        }
        System.out.println();
        for (int i = 100; i >= 0; i--) {
            if (i % 2 != 0) {
                mass[a] = i;
                System.out.print(mass[a] + " ");
            }
        }
    }

    static void z3() {
        var mass = new int[15];
        var a = new Random();
        var b = 0;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = a.nextInt(99);
            if (mass[i] % 2 == 0) {
                ++b;
            }
        }
        System.out.println(Arrays.toString(mass));
        System.out.printf("Число четных элементов = %d", b);
    }

    static void z4() {
        var mass = new int[20];
        var a = new Random();
        var b = 0;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = a.nextInt(20);
            System.out.print(mass[i] + " ");
            if (mass[i] % 2 != 0) {
                mass[i] = b;
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(mass));
    }

    static void z5() {
        var mass1 = new int[5];
        var mass2 = new int[5];
        var a = new Random();
        var b = 0;
        var c = 0;
        for (int i = 0; i < mass1.length; i++) {
            mass1[i] = a.nextInt(15);
            b = b + mass1[i];
        }
        System.out.println(Arrays.toString(mass1));
        for (int i = 0; i < mass2.length; i++) {
            mass2[i] = a.nextInt(15);
            c = c + mass2[i];
        }
        System.out.println(Arrays.toString(mass2));
        if (b / mass1.length > c / mass2.length) {
            System.out.println("Среднее арифметическое 1-го массива больше");
        } else if (b / mass1.length < c / mass2.length) {
            System.out.println("Среднее арифметическое 2-го массива больше");
        } else {
            System.out.println("Среднее арифметическое 2-х массивов равны");
        }
    }

    static void z6() {
        var mass = new int[4];
        var a = new Random();
        var b = true;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = a.nextInt(10);
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 1; i < mass.length; i++) {
            if (mass[i] <= mass[i - 1]) {
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }
    }

    static void z7() {
        var mass = new int[12];
        var a = new Random();
        var max = 0;
        var ind = 0;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = a.nextInt(15);
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 1; i < mass.length; i++) {
            if (max <= mass[i]) {
                max = mass[i];
                ind = i;
            }
        }
        System.out.printf("Максимальный элемент = %d\nИндекс его последнего вхождения = %d", max, ind);
    }
}
