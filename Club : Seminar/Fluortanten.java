import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Fluortanten
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Long> prefix = new ArrayList<>();
        
        for (int i = 0, j = 0; i < n; i++) {
            int in = scan.nextInt();
            if (in != 0) {
                input.add(in);
                if (prefix.size() == 0) {
                    prefix.add((long) in);
                }
                else {
                    prefix.add((long) (in * (j + 1)) + prefix.get(prefix.size() - 1));
                }
                j++;
            }
        }
        
        long max = prefix.get(prefix.size() - 1);
        long sum = 0;
        
        
        for (int i = prefix.size() - 1; i > 0; i--) {
            sum += (input.get(i) * (i + 2));
            max = Math.max(max, sum + prefix.get(i - 1));
        }
        
        //considering last option
        max = Math.max(max, sum + input.get(0) * 2);
        
        System.out.println(max);
     
        
    }

}
