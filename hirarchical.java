class main {
    void display() {
        System.out.println("Main");
    }
    class main1 extends main {
        void display() {
            System.out.println("Main1");
        }
    }
    class main2 extends main {
        void display() {
            System.out.println("Main2");
        }
    }
}
public class hirarchical extends main {
    public static void main(String[] args) {
        hirarchical obj1 = new hirarchical();
        main1 obj2 = obj1.new main1();
        main2 obj3 = obj1.new main2();
        
        obj1.display(); 
        obj2.display(); 
        obj3.display(); 
}
}