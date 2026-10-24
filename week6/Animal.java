public abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // ให้ลูก Class ไปเขียนรายละเอียดเอง
    public abstract void makeSound();

    // Method นี้ลูก Class ใช้ได้เลย
    public void eat() {
        System.out.println(name + " is eating");
    }
}