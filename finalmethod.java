public class finalmethod {
    final void display() {
        System.out.println("This is a final method.");
    }
}

class Subclass extends finalmethod {
    void display() { // This line would cause a compilation error
        System.out.println("Trying to override final method.");
    }
}
