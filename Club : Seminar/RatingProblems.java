import java.util.Scanner;

public class RatingProblems
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        
        double min = 0;
        double max = 0;
        
        for (int i = 0; i < k; i++) {
            int input = scan.nextInt();
            min += input;
            max += input;
        }
        
        min = (min + (-3 * (n - k))) / n;
        max = (max + (3 * (n - k))) / n;
        
        System.out.println(min + " " + max);
    }

}
