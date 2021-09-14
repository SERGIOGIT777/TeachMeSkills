package DZ6.ZD2;

public class Person{
    private String name;
    private Jacket jacket;
    private Pants pants;
    private Shoes shoes;

    public Person(String name, Pants pants, Jacket jacket, Shoes shoes) {
        this.name = name;
        this.pants = pants;
        this.jacket = jacket;
        this.shoes = shoes;
    }

    public String getName() {
        return name;
    }

    public void dress(){
        System.out.print(getName() + " ");
        pants.dress();
        shoes.dress();
        jacket.dress();

    }

    public void undress(){
        System.out.print(getName() + " ");
        jacket.undress();
        shoes.undress();
        pants.undress();
    }
}
