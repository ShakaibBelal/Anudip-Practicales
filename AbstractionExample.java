abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("This animal eats food.");
    }
    Animal() {
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound();
        myDog.eat();
    }
}