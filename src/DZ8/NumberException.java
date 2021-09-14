package DZ8;

public class NumberException extends RuntimeException {
    public NumberException(String name) {
        super(String.format("Число четное, автомобиль марки %s не завелся", name));
    }
}
