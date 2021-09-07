package OOP2.ZD2;

public class ShoesPerson implements  Shoes{
    @Override
    public void dress() {
        System.out.print(" одевает обувь ");
    }

    @Override
    public void undress() {
        System.out.print(" снимает обувь ");
    }
}
