public class student {
        static String College="DYP";
        String name;
        int age;
    student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args) {
    student s1 = new student("Shakaib", 22);
    student s2 = new student("Belal", 23);       
   
    System.out.println("Name: " + s1.name + ", Age: " + s1.age + ", College: " + s1.College);
    System.out.println("Name: " + s2.name + ", Age: " + s2.age + ", College: " + s2.College);

}
}
