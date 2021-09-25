package DZ11;

public class Students {
    String name;
    int number;
    Speciality sp;

    public Students(int kurs) {
    }

    public Students(String name, int number, Speciality sp) {
        this.name = name;
        this.number = number;
        this.sp = sp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Speciality getSp() {
        return sp;
    }

    public void setSp(Speciality sp) {
        this.sp = sp;
    }

    @Override
    public String toString(){
        return "Имя студента: " + name +
                ", факультет: " + sp + ", курс: " + number;
    }
}
