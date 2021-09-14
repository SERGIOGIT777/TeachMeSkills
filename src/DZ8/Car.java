package DZ8;

import java.util.Random;

public class Car implements StartCar {
    private String marka;
    private Integer speed;
    private Integer price;

    public Car() {
    }

    public Car(String marka, Integer speed, Integer price) {
        this.marka = marka;
        this.speed = speed;
        this.price = price;
    }

    public String getMarka() {
        return marka;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getPrice() {
        return price;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public Object start() {
        var rnd = new Random().nextInt(20);
        if (rnd % 2 == 0) {
            throw new NumberException(this.marka);
        } else {
            System.out.printf("Автомобиль марки %s завелся\n", this.marka);
        }
        return null;
    }
}
