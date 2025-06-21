class multi{
    void display(){
        System.out.println("This is Multi-level Inheritance class.");
    }
}
class multi1 extends multi{
    void display2(){
        System.out.println("This is Multi-level Inheritance class 1.");
    }
}
public class multilevel extends multi1 {
    public static void main(String[] args) {
        multilevel obj = new multilevel();
        obj.display();  
        obj.display2(); 
    }
}