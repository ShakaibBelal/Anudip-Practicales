
class single {
    void display() {
        System.out.println("This is single Inheritance class.");
    }
}

public class singleinherit extends single {
    public static void main(String[] args) {
    
        singleinherit obj = new singleinherit();
        obj.display(); 
    }
}