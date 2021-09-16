package DZ9.ZD3;

public class textExamenetion implements Examenation {

    public textExamenetion() {
    }

    @Override
    public int textExam(String str, String str1) {
        var count = 0;
        if (str.length() != 0) {
            var stroka = str.split(" ");
            for (int i = 0; i < stroka.length; i++) {
                var word = new StringBuilder(stroka[i]);
                if (word.toString().replaceAll("\\,", "").equals(str1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
