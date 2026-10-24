public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    // เขียน Method ที่ Animal กำหนดไว้
    @Override
    public void makeSound() {
        System.out.println("Say : hong hong");
    }

    public void run() {
        System.out.println(name + " is running");
    }
}