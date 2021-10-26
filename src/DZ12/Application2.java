package DZ12;

import java.io.File;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {
        var file = new File("/home/sergio/Загрузки");
        getFile(file, ".txt");
    }

    public static void getFile (File file, String names) {
        Stream.ofNullable(file.listFiles(File::isFile))
                        .flatMap(Stream::of)
                                .forEach(f->getFile(f, names));
        Stream.ofNullable(file.listFiles((dir, name) -> name.endsWith(names)))
                .flatMap(Stream::of)
                .forEach(System.out::println);

    }
}
