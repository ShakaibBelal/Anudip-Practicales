public class staticfun {

        public static void printInfo(){
            System.out.println("This is printInfo");
        }
        public  static  int add(int a,int b){
            int  num1=a;
            int num2=b;
            return num1+num2;
        } 
    public static void main (String[] args){
      
        printInfo();
        System.out.println(add(10,20));
    }
}
