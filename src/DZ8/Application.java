package DZ8;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        var car = new ArrayList<>();
        try {
            car.add(new Car("Audi", 180, 10000000).start());
        } catch (NumberException e) {
            e.printStackTrace();
        }
        try {
            car.add(new Car("Mercedes", 200, 400000000).start());
        } catch (NumberException e) {
            e.printStackTrace();
        }
        try {
            car.add(new Car("BMV", 230, 1300000000).start());
        } catch (NumberException e) {
            e.printStackTrace();
        }
    }
}
