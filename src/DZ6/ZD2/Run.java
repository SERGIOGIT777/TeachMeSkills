package DZ6.ZD2;

public class Run {
    public static void main(String[] args) {
        var person = new Person("Vasia", new PantsPerson(), new JacketPerson(), new ShoesPerson());
        person.dress();
        System.out.println();
        person.undress();
    }
}
