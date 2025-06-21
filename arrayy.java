public class arrayy {
    public static void main(String[] args) {

        // int [] c = new int[5];
        // int a[]={20,30};
        int b[][] = new int[5][5];
        int i = 0;
        int j = 0;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                b[i][j] = i + j;

                System.out.println(b[i][j]);
            }
        }
    }
}
