package OOP2.ZD1.legs;

public class SamsungLegs implements ILeg {
    private int price;

    public SamsungLegs(int price) {
        this.price = price;
    }

    public SamsungLegs() {
    }

    @Override
    public void step() {
        System.out.println("Щагают ноги Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
