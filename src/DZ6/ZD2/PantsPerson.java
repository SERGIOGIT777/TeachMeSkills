package DZ6.ZD2;

public class PantsPerson implements Pants{
    @Override
    public void dress() {
        System.out.print(" одевает штаны ");
    }

    @Override
    public void undress() {
        System.out.print(" снимает штаны ");
    }
}
