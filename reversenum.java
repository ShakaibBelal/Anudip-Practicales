public class reversenum {
    public static void main(String[] args) {
        int num = 1234;
        int rem = 0;
        int sum=0;
        while (num != 0) {
            rem = (num % 10);
            num = num / 10;
            sum=(rem*10)+num;
            
            System.out.println(sum);  
        }
    }
}
