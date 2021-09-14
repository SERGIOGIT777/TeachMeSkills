package DZ7;

import java.util.Scanner;

public class ZD2 {
    public static void main(String[] args) {
        var string = new Scanner(System.in).nextLine();
        System.out.println(rename(string));
    }

    public static String rename(String str){
        var str1 = new StringBuffer(str);
        var s1 = str1.charAt(3);
        var s2 = str1.charAt(0);
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == s1) {
                str1.setCharAt(i, s2);
            }
        }
        return str1.toString();
    }
}
