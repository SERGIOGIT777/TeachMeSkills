package DZ11;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class University {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());;
        List<Students> students = Arrays.asList(
                new Students("Alex", 1, Speciality.Physics),
                new Students("Rika", 4, Speciality.Biology),
                new Students("Julia", 2, Speciality.Biology),
                new Students("Steve", 4, Speciality.History),
                new Students("Mike", 1, Speciality.Finance),
                new Students("Hinata", 2, Speciality.Biology),
                new Students("Richard", 1, Speciality.History),
                new Students("Kate", 2, Speciality.Psychology),
                new Students("Sergey", 4, Speciality.ComputerScience),
                new Students("Maximilian", 3, Speciality.ComputerScience),
                new Students("Tim", 5, Speciality.ComputerScience),
                new Students("Ann", 1, Speciality.Psychology)
        );
        while (true) {
            var scan = new Scanner(System.in);
            System.out.println("Выберите действие:\n1 - Группировка студентов по курсу" +
                    "\n2 - Список специальностей в алфавитном порядке\n3 - Количество учащихся на каждой из специальностей" +
                    "\n4 - Таблица студентов по специальности и курсу" +
                    "\n5 - Поиск по спеиальности (заданой)\n6 - Список курсов и специальностей\n7 - Выход");
            var ind = scan.nextInt();
            if (ind == 7) break;
            if (ind < 0 || ind > 6) {
                System.err.println("Не верный идентификатор");
                continue;
            }
            switch (ind) {
                case 1 -> students.stream()
                        .collect(Collectors.groupingBy(Students::getNumber))
                        .entrySet()
                        .forEach(System.out::println);
                case 2 -> students.stream()
                        .map(Students::getSp)
                        .distinct()
                        .sorted(Comparator.comparing(Enum::name))
                        .forEach(System.out::println);
                case 3 -> students.stream()
                        .collect(Collectors.groupingBy(Students::getSp, Collectors.counting()))
                        .forEach((specility, numberSpecility) -> System.out.println(specility + " " + numberSpecility));
                case 4 -> {
                    Map<Speciality, Map<Integer, List<Students>>> student = students.stream()
                            .sorted(Comparator.comparing(Students::getSp, Comparator.comparing(Enum::name))
                                    .thenComparing(Students::getNumber))
                            .collect(Collectors.groupingBy(Students::getSp, LinkedHashMap::new,
                                    Collectors.groupingBy(Students::getNumber)));
                    student.forEach((speciality, key) -> {
                        System.out.println(speciality);
                        key.forEach((kurs, list) -> System.out.format("%d: %s%n",
                                kurs, list.stream()
                                        .map(Students::getName)
                                        .collect(Collectors.joining(", "))));
                        System.out.println();
                    });
                }
                case 5 -> students.stream()
                        .filter((stud -> EnumSet.of(Speciality.ComputerScience)
                                .contains(stud.getSp())))
                        .forEach(System.out::println);
                case 6 -> students.stream()
                        .flatMap(p-> Stream.of(String.format("Курс %d, специальность %s", p.getNumber(), p.getSp())))
                        .distinct()
                        .sorted()
                        .forEach(System.out::println);
            }
        }
    }
}
