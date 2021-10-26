package DZ12;

import java.io.File;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        var file = new File("/home/sergio/Загрузки");
        sortFile(file);
        sortFile(file).forEach((key, value) -> {
            Optional.ofNullable(value).ifPresent(
                    c -> c.stream().sorted().forEach(System.out::println));
        });
    }

    public static Map<Boolean, List<FileContainer>> sortFile(File file) {
        return Stream.ofNullable(file.listFiles())
                .flatMap(Stream::of)
                .map(f2 -> {
                    var fc = new FileContainer(f2);
                    fc.nodes = sortFile(f2);
                    return fc;
                }).collect(Collectors.groupingBy(FileContainer::isDirectory));
    }

    private static class FileContainer implements Comparable<FileContainer>, Serializable {
        File file;
        Map<Boolean, List<FileContainer>> nodes;

        public FileContainer(File file) {
            this.file = file;
            this.nodes = new TreeMap<>();
        }

        public boolean isDirectory() {
            return file.isDirectory();
        }

        @Override
        public int compareTo(FileContainer o) {
            return this.file.compareTo(o.file);
        }

        @Override
        public String toString() {
            return "FileContainer{" +
                    "file=" + file +
                    ", nodes=" + nodes +
                    '}';
        }
    }
}
