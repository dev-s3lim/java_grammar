package C04Interface;

public class C02Cat implements C01AnimalInterface1, C01AnimalInterface2{
    public void makeSound() {
        System.out.println("야옹야옹");
    }

    @Override
    public String play(String a, String b) {
        return "";
    }
}
