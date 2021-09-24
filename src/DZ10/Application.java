package DZ10;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        var shop = new Shop();

        while (true) {
            var scan = new Scanner(System.in);
            System.out.println("Выберите действие:\n1 - Вывод всех товаров\n2 - Добавление товара\n3 - Удаление товара\n" +
                    "4 - Редактирование товара\n5 - Выход");
            var a = scan.nextInt();
            if (a == 5) break;
            if (a < 1 || a > 4) {
                System.err.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (a) {
                case 1 -> {
                    System.out.println("Выберите действие:\n1 - Сортировка по цене (возрастание)\n" +
                            "2 - Сортировка по цене (убывание)\n3 - Сортировка по добавлению");
                    var sorted = scan.nextInt();
                    switch (sorted) {
                        case 1 -> shop.listUP();
                        case 2 -> shop.listDOWN();
                        case 3 -> shop.listNew();
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.println("0 - Добавить\n1 - Выход");
                        var znach = scan.nextInt();
                        if (znach == 1) break;
                        else {
                            System.out.println("Введите id");
                            var id = scan.nextInt();
                            System.out.println("Введите название товара");
                            var name = scan.next();
                            System.out.println("Введите цену товара");
                            var price = scan.nextInt();
                            shop.insert(id, new Tovar(id, name, price));
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Введите id для удаления товара");
                    var id = scan.nextInt();
                    shop.delete(id);
                }
                case 4-> {
                    System.out.println("Введите id");
                    var id = scan.nextInt();
                    System.out.println("Введите название товара");
                    var name = scan.next();
                    System.out.println("Введите цену товара");
                    var price = scan.nextInt();
                    shop.update(id, name, price);
                }
            }
        }
    }
}
