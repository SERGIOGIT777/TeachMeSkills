package DZ9.ZD4;

import java.io.*;
import java.util.ArrayList;

public class Serizable {
    public static void main(String[] args) {
        var cars = new ArrayList<>();
        cars.add(new Car("BMV", 200, 12000));
        cars.add(new Car("Mercedes", 210, 15000));
        try (ObjectOutputStream ois =
                     new ObjectOutputStream(new FileOutputStream("./src/DZ9/ZD4/serizable.dat"))) {
            ois.writeObject(cars);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        var carsOutput = new ArrayList<Car>();
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("./src/DZ9/ZD4/serizable.dat"))) {
            carsOutput = ((ArrayList<Car>)ois.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for (Car car : carsOutput) {
            System.out.printf("Марка - %s, скорость - %d км.ч, стоимость - %d $\n", car.getMarka(),
                    car.getSpeed(), car.getPrice());
        }
        System.out.println("\nСерилизация выполнена");
    }
}
