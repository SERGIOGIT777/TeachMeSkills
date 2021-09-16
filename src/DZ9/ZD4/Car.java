package DZ9.ZD4;

import java.io.Serializable;

public class Car implements Serializable {
    private String marka;
    private int speed;
    private int price;

    public Car(String marka, int speed, int price) {
        this.marka = marka;
        this.speed = speed;
        this.price = price;
    }

    public String getMarka() {
        return marka;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }
}
