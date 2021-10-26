package DZ12;

import java.io.File;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        var file = new File("/home");

        getDir(file);
    }
    public static void getDir(File file){
        var list = file.listFiles(File::isDirectory);
        Stream.ofNullable(list)
                .flatMap(Stream::of)
                .peek(Application::getDir)
                .forEach(System.out::println);
    }
}
