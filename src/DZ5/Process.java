package DZ5;

public interface Process {
    void info();
    void start();
    void close();
    void limited(Integer open);
    void limitless(Integer close);
}
