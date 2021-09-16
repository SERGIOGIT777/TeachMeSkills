package DZ9.ZD2;

public class TextFormatter implements formatterInterface{

    public TextFormatter() {
    }

    @Override
    public String polimorfInput(String str) {
        var proverka = false;
        var count = 0;
        if (str.length() != 0) {
            var stroka = str.split(" ");
            for (int i = 0; i < stroka.length; i++) {
                var word = new StringBuilder(stroka[i]);
                if (word.length() > 3 && word.reverse().toString().equals(stroka[i])) {
                    count++;
                }
            }
        }
        proverka = count > 0;
        return String.valueOf(proverka);
    }

    @Override
    public int inputString(String str) {
        int count = 0;
        if (str.length() != 0) {
            count++;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
}
