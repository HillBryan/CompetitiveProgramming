import java.util.*;

public class PerfectSubarray
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
        	int s = scan.nextInt();
        	int[] arr = new int[s];
        	for (int j = 0; j < s; j++) {
        		arr[j] = scan.nextInt();
        	}
        	System.out.println("Case #" + (i + 1) + ": " + solve(arr));
        }
    }
    
    public static int solve(int[] arr) {
    	int count = 0;

    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0, k = j + i; k < arr.length; j++, k++) {
    			long sum = 0;
    			for (int l = j; l <= k; l++) {
    				sum += arr[l];
    			}
    			if ((int)(Math.sqrt(sum)) == Math.sqrt(sum)) count++;
    		}
    	}
    	return count;
    }
}