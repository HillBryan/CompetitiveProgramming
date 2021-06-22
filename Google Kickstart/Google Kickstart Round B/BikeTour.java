import java.util.*;

public class BikeTour
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
        	int n = scan.nextInt();
        	int[] ok = new int[n];
        	for (int j = 0;j < n; j++) {
        		ok[j] = scan.nextInt();
        	}
        	System.out.println("Case #" + (i + 1) + ": " + solve(ok));
        }
    }
    
    public static int solve(int[] arr) {
    	int count = 0;
    	
    	for (int i = 1; i < arr.length - 1; i++) {
    		if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) count++;
    	}
    	
    	return count;