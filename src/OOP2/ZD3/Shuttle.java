package OOP2.ZD3;

import java.util.Random;

public class Shuttle implements IStart {
    public static final String BLUE = "\033[0;34m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String RESET = "\033[0m";

    @Override
    public boolean examination() {
        var gen = new Random().nextInt(10);
        return gen > 3;
    }

    @Override
    public void runner() {
        System.out.println(BLUE + "Двигатели шатла запущены.\nВсе системы в норме." + RESET);
    }

    @Override
    public void start() {
        System.out.println(YELLOW_BOLD + "Старт Шатла НАДЕЖДА." + RESET);
    }
}
