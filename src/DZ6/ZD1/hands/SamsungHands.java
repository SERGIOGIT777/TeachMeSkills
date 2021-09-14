package DZ6.ZD1.hands;

public class SamsungHands implements IHand {
    private int price;

    public SamsungHands(int price) {
        this.price = price;
    }

    public SamsungHands() {
    }

    @Override
    public void upHand() {
        System.out.println("Поднимается рука Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
