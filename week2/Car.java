
public class Car {

    String Brand;
    int speed;

    // Constructor
    public Car(String Brand, int speed) {
        this.Brand = Brand;
        this.speed = speed;
    }

    public static void main(String[] args) {

        String Brand = "...Honda...";
        int speed = 120;

        // สร้าง Object
        Car car = new Car(Brand, speed);

        //System.out.println("test");

        // เรียกใช้ Method
        car.carBrand();
        car.carEngineStart();
        car.carDriver();
        car.carEngineStop();
    }

    // แสดงยี่ห้อรถ
    void carBrand() {
        System.out.println("Brand : " + Brand);
    }

    // สตาร์ทเครื่องยนต์
    void carEngineStart() {
        System.out.println("Car Engine Start .....");
    }

    // ขับรถ
    void carDriver() {
        System.out.println( "Car is Driving" +speed);
    }

    // ดับเครื่องยนต์
    void carEngineStop() {
        System.out.println("Car Engine Stop .....");
    }
}