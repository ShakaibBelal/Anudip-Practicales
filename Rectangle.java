/* 
class heritance {
    static void Show() {
        System.out.println("Super");
    }
}

public class ss extends heritance {
    public static void main(String[] args) {
        ss s1 = new ss();
        heritance h1 = new heritance();
        s1.Show();
        h1.Show();    
    }
}*/
class shape{
    int area;
    public void area(int len,int wid){
        area=len*wid;
        
    }
    public void display(){
        System.out.println("Area of shape is "+area);
    }
}
public class Rectangle extends shape{
    public static void main (String [] args){
        Rectangle r1= new Rectangle();
        r1.area(10,10);
        r1.display();

    } 
}