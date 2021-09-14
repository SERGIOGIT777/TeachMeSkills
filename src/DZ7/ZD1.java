package DZ7;

import java.util.Scanner;

public class ZD1 {
    public static void main(String[] args) {
        var scan = new Scanner(System.in).nextLine();
        try {
            System.out.println(trim(scan));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String trim(String str) throws StringIndexOutOfBoundsException {
        var str1 = new StringBuffer(str);
        var s1 = "a";
        var s2 = "b";
        return str1.substring(str1.indexOf(s1), str1.lastIndexOf(s2));
    }
}
