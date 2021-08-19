package DZ1;

import java.util.Scanner;

public class FullDz1 {
    public static void main(String[] args) {
        System.out.println("Введите номер задачи");
        Scanner scan = new Scanner(System.in);
        int dz = scan.nextInt();
        switch (dz) {
            case 1 -> {
                System.out.println("Введите число");
                int a1 = scan.nextInt();
                int b1 = String.valueOf(Math.abs(a1)).length();
                if ((a1 > 0) && (b1 == 1)) {
                    System.out.println("Это положительное однозначное число");
                } else if ((a1 < 0) && (b1 == 1)) {
                    System.out.println("Это отрицательное однозначное число");
                } else if ((a1 > 0) && (b1 == 2)) {
                    System.out.println("Это положительное двузначное число");
                } else if ((a1 < 0) && (b1 == 2)) {
                    System.out.println("Это отрицательное двузначное число");
                } else if ((a1 > 0) && (b1 == 3)) {
                    System.out.println("Это положительное трехзначное число");
                } else if ((a1 < 0) && (b1 == 3)) {
                    System.out.println("Это отрицательное трехзначное число");
                } else if ((a1 > 0) && (b1 > 3)) {
                    System.out.println("Это положительное число имеющее " + b1 + " чисел");
                } else {
                    System.out.println("Это отрицательное число имеющее " + b1 + " чисел");
                }
            }
            case 2 -> {
                System.out.println("Введите сторону 1");
                int a2 = scan.nextInt();
                System.out.println("Введите сторону 2");
                int b2 = scan.nextInt();
                System.out.println("Введите сторону 3");
                int c2 = scan.nextInt();
                System.out.println(((a2 + b2 > c2) && (a2 + c2 > b2) && (b2 + c2 > a2)) ? "Треугольник существует" : "Треугольник не существует");
            }
            case 3 -> {
                System.out.println("Enter number");
                int a3 = scan.nextInt();
                if (a3 > 0) {
                    System.out.println("Number = " + (++a3));
                } else if (a3 < 0) {
                    System.out.println("Number = " + (a3 - 2));
                } else {
                    System.out.println("Number = " + 10);
                }
            }
            case 4 -> {
                System.out.println("Enter numbers");
                int a4 = scan.nextInt();
                int b4 = scan.nextInt();
                int c4 = scan.nextInt();
                if (a4 > 0) {
                    a4 = 1;
                } else {
                    a4 = 0;
                }
                if (b4 > 0) {
                    b4 = 1;
                } else {
                    b4 = 0;
                }
                if (c4 > 0) {
                    c4 = 1;
                } else {
                    c4 = 0;
                }
                System.out.println("Количество положительных чисел = " + (a4 + b4 + c4));
            }
            case 5 -> {
                System.out.println("Enter numbers");
                int a5 = scan.nextInt();
                int b5 = scan.nextInt();
                int c5 = scan.nextInt();
                int d = 0;
                int k = 0;
                if (a5 > 0) {
                    ++d;
                } else {
                    ++k;
                }
                if (b5 > 0) {
                    ++d;
                } else {
                    ++k;
                }
                if (c5 > 0) {
                    ++d;
                } else {
                    ++k;
                }
                System.out.println("Количество положительных чисел = " + d);
                System.out.println("Количество отрицательных чисел = " + k);
            }
            case 6 -> {
                System.out.println("Enter numbers");
                int a6 = scan.nextInt();
                int b6 = scan.nextInt();
                System.out.println((a6 > b6) ? ("Большее число = " + a6) : ("Большее число = " + b6));
            }
            case 7 -> {
                System.out.println("Enter numbers");
                int a7 = scan.nextInt();
                if (a7 < 0) {
                    System.out.println("Недопустимое число");
                } else if ((a7 % 10 == 1) && (a7 % 100 != 11)) {
                    System.out.println(a7 + " программист");
                } else if (((a7 % 10 >= 2) && (a7 % 10 <= 4)) && ((a7 % 100 < 10) || (a7 % 100 > 20))) {
                    System.out.println(a7 + " программиста");
                } else {
                    System.out.println(a7 + " программистов");
                }
            }
            default -> System.out.println("Нет такой задачи");
        }
    }
}
