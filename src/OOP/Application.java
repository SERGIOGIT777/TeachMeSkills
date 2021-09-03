package OOP;

public class Application {
    public static void main(String[] args) {
        var comp = new Computer(2.34, 8, 500, 5, 5);
        comp.info();
        while (comp.getCloser() != -1 || comp.getOpener() != -1) {
            comp.start();
            comp.limited(10);
            if (comp.getOpener() == -1) {
                comp.start();
                return;
            }
            comp.close();
            comp.limitless(10);
            if (comp.getCloser() == -1) {
                comp.close();
                return;
            }
        }
    }
}
