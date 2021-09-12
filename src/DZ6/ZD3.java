package DZ6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZD3 {
    public static void main(String[] args) {
        var polimorf = new String[]{"vfvf", "vffv", "reet", "reer"};
        System.out.println(trimInsert(polimorf));
        System.out.println(trimInsert2(polimorf));
    }

    public static String trimInsert(String[] strings){
        var reverse = new String[4];
        for (int i = 0; i < strings.length; i++) {
            var builder = new StringBuilder(strings[i]);
            if (builder.reverse().toString().equals(strings[i])) {
                reverse[i] = builder.toString();
            }
        }
        return Arrays.toString(reverse);
    }

    public static String trimInsert2(String[] strings){
        List<String> pol = new LinkedList<>();
        for (String string : strings) {
            var builder = new StringBuilder(string);
            if (builder.reverse().toString().equals(string)) {
                pol.add(builder.toString());
            }
        }
        return String.valueOf(pol);
    }
}
