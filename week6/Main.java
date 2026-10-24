public class Main {

    public static void main(String[] args) {

        // สร้าง Object Dog
        Dog dog = new Dog("Lucky");

        dog.eat();
        dog.makeSound();
        dog.run();


        // สร้าง Object Cat
        Cat cat = new Cat("Cola");

        cat.eat();
        cat.makeSound();
        cat.scratch();


        // สร้าง Object Bird
        Bird bird = new Bird("Eang");

        bird.eat();
        bird.makeSound();
        bird.fly();
    }
}