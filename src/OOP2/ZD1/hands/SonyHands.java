package OOP2.ZD1.hands;

public class SonyHands implements IHand {
    private int price;

    public SonyHands() {
    }

    public SonyHands(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Поднимается рука Sony");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
