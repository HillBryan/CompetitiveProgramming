import java.util.*;

public class MatrixInverse {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (scan.hasNext()) {
            i++;
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            int det = 0;
            
            if (a != 0 || b != 0 || c != 0 || d != 0) det = 1 / ((a * d) - (b * c));
            
            System.out.println("Case " + i + ": ");
            System.out.println(d * det + " " + -b * det);
            System.out.println(-c * det + " " + a * det);
        }
    }
}