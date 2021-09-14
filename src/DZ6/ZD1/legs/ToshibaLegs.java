package DZ6.ZD1.legs;

public class ToshibaLegs implements ILeg {
    private int price;

    public ToshibaLegs(int price) {
        this.price = price;
    }

    public ToshibaLegs() {
    }

    @Override
    public void step() {
        System.out.println("Щагают ноги Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
