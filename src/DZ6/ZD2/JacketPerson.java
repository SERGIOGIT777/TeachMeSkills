package DZ6.ZD2;

public class JacketPerson implements Jacket{
    @Override
    public void dress() {
        System.out.print(" одевает куртку ");
    }

    @Override
    public void undress() {
        System.out.print(" снимает куртку ");
    }
}
