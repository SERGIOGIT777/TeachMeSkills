package OOP;

import java.util.Random;
import java.util.Scanner;

public class Computer implements Process {
    private final Double processor;
    private final Integer ram;
    private final Integer hdd;
    private Integer opener;
    private Integer closer;

    public Computer(Double processor, Integer ram, Integer hdd, Integer opener, Integer closer) {
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.opener = opener;
        this.closer = closer;
    }

    public Integer getOpener() {
        return opener;
    }

    public void setOpener(Integer opener) {
        this.opener = opener;
    }

    public Integer getCloser() {
        return closer;
    }

    public void setCloser(Integer closer) {
        this.closer = closer;
    }

    @Override
    public void info() {
        System.out.printf("Computer: processor - %.2f GHz, ram - %d Gb, hdd - %d Gb, ресурс запусков - %d запусков, " +
                "ресурс отключений - %d отключений\n", processor, ram, hdd, opener, closer);
    }

    @Override
    public void start() {
        System.out.println("Для включения компьютера выберите число 0 или 1");
        var scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            var a = scanner.nextInt();
            if (a >= 2) {
                System.err.println("Не верный идентификатор");
                System.exit(a);
            }
            var number = new Random();
            var b = number.nextInt(2);
            if (opener == -1) {
                System.err.println("Комп сгорел");
            }
            if (opener != -1) {
                if (a == b) {
                    setOpener(++opener);
                } else {
                    opener = -1;
                    System.err.println("Непредвиденная ошибка системы!!!!!!!!!!!!!");
                }
            }
        } else {
            var a = 1;
            System.err.println("Не верный идентификатор");
            System.exit(a);
        }
    }

    @Override
    public void close() {
        System.out.println("Для выключения компьютера выберите число 0 или 1");
        var scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            var a = scanner.nextInt();
            if (a >= 2) {
                System.err.println("Не верный идентификатор");
                System.exit(a);
            }
            var number = new Random();
            var b = number.nextInt(2);
            if (closer == -1) {
                System.err.println("Комп сгорел");
            }
            if (closer != -1) {
                if (a == b) {
                    setCloser(++closer);
                } else {
                    closer = -1;
                    System.err.println("Непредвиденная ошибка системы!!!!!!!!!!!!!");
                }
            }
        } else {
            var a = 1;
            System.err.println("Не верный идентификатор");
            System.exit(a);
        }
    }

    @Override
    public void limited(Integer open) {
        if (open < opener) {
            System.out.println("Превышен лимит ресурсов\nКОМП СГОРЕЛ!!!!");
            System.exit(opener);
        }
    }

    @Override
    public void limitless(Integer close) {
        if (close < closer) {
            System.out.println("Превышен лимит ресурсов\nКОМП СГОРЕЛ!!!!");
            System.exit(closer);
        }
    }
}
