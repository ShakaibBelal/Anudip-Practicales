final public class finalclassex {
 void display() {
     System.out.println("This is a final class method.");
 }
}
class Subclass extends finalclassex {
    // This class cannot extend finalclassex because it is declared as final
    // Uncommenting the following method will cause a compilation error
    // void display() {
    //     System.out.println("Trying to override final class method.");
    // }
}
