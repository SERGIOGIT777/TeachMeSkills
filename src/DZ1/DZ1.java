package DZ1;

import java.util.Scanner;

public class DZ1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number");
        int a = scan.nextInt();

        if (a > 0) {
            System.out.println("Number = " + (++a));
        } else if (a < 0) {
            System.out.println("Number = " + (a-2));
        } else {
            System.out.println("Number = " + 10);
        }
    }
}
