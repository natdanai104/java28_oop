public class Cat extends Animal {

    // Constructor ของ Cat
    public Cat(String name) {
        super(name);
    }

    // ทำเสียง
    @Override
    public void makeSound() {
        System.out.println("Say : meow meow");
    }

    // ข่วน
    public void scratch() {
        System.out.println(name + " is scratching");
    }
}