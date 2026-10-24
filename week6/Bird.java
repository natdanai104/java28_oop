public class Bird extends Animal {

    // Constructor ของ Bird
    public Bird(String name) {
        super(name);
    }

    // ทำเสียง
    @Override
    public void makeSound() {
        System.out.println("Say : jiw jiw");
    }

    // บิน
    public void fly() {
        System.out.println(name + " is flying");
    }
}