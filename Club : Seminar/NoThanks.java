import java.util.Arrays;
import java.util.Scanner;

public class NoThanks
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        
        Arrays.sort(arr);
        
        long score = 0;
        
        for (int i = 0; i < arr.length; i++) {
            score += arr[i];
            while (i != arr.length - 1 && arr[i] == arr[i + 1] - 1) {
                i++;
            }
            
        }
        
        System.out.println(score);
    }

}
