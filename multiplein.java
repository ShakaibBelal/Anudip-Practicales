interface Innermultiple {
    void display();
}

interface InnerInnermultiple {
    void displayInner();
}

public class multiplein implements Innermultiple, InnerInnermultiple {

    public void display() {
        System.out.println("Display from Innermultiple interface");
    }

    public void displayInner() {
        System.out.println("DisplayInner from InnerInnermultiple interface");
    }

    public static void main(String[] args) {
        multiplein obj = new multiplein();
        obj.display();
        obj.displayInner();
    }
}
