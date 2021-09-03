package OOP;

import java.util.List;

public interface Process {
    void info();
    void start();
    void close();
    void limited(Integer open);
    void limitless(Integer close);
}
