package Other;
class Car {
    String color;
    int doors;

    Car(){} //default constructor
    Car(String color, int doors) { //constructor
        this.color = color;
        this.doors = doors;
    }
    public void getColor() { //getter methods
        System.out.println(color);
    }
    public void getDoors() {
        System.out.println(doors);
    }
    public void setColor(String color) { //setter methods
        this.color = color;
        System.out.println("The color is " + color);
    }
    public void doorCount(int doors) {
        this.doors = doors;
        System.out.println("Has " + doors + " doors");
    }
}
class BMW extends Car{ //inheritance
    char model;
    public void setModelType(char model) {
        this.model = model;
        System.out.println("The model is " + model);
    }
}
public class OOP { //tester
    public static void main(String[] args) {
        BMW car = new BMW();
        car.setColor("Black"); //inherited method
        car.doorCount(4); //inherited method
        car.setModelType('M'); //method from BMW class

        System.out.println();

        Car car2 = new Car("White", 2); //using non-default constructor
        car2.getColor();
        car2.getDoors();
    }
}
