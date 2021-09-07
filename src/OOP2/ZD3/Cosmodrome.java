package OOP2.ZD3;

import java.util.Scanner;

public class Cosmodrome {

    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[0;32m";
    public static int rez = 0;

    public static void main(String[] args) {
        var chelnok = new Shuttle();
        start(chelnok);
        var chelnok1 = new ShuttleM();
        start(chelnok1);
        var chelnok2 = new ShuttleN();
        start(chelnok2);
        System.out.println("Количество запущенных челноков = " + GREEN + rez + RESET + " из 3-х");
    }

    static void start(IStart iStart) {
        System.out.println("Произвести предстартовую проверку шатла?\n1 - yes, 2 - no");
        var chet = new Scanner(System.in);
        if (!chet.hasNextInt()) {
            var a = 1;
            System.err.println("Недопустимый идентификатор");
            System.exit(a);
        } else {
            switch (chet.nextInt()) {
                case 1 -> {
                    if (!iStart.examination()) {
                        System.err.println("Предстартовая проверка провалена");
                    } else {
                        System.out.println(GREEN + "Предстартовая проверка выполнена" + RESET);
                        iStart.runner();
                        for (int i = 10; i > 0; i--) {
                            System.out.println("До старта осталось " + i + " секунд");
                        }
                        iStart.start();
                        rez = rez + 1;
                    }
                }
                case 2 -> {
                    System.out.println("Запуск отменен!!!");
                }
                default -> System.err.println("Не верный идентификатор");
            }
        }
    }
}
