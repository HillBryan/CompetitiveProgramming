import java.util.*;

public class BusRoutes
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
        	int n = scan.nextInt();
        	long d = scan.nextLong();
        	long[] rout = new long[n];
        	for (int j = 0; j < n; j++) {
        		rout[j] = scan.nextLong();
        	}
        	System.out.println("Case #" + (i + 1) + ": " + solve(rout, d));
        }
    }
    
    public static long solve(long[] arr, long d) {
    	for (int i = arr.length - 1; i > -1; i--) {
    		if (i == arr.length - 1) arr[i] = (d / arr[i]) * arr[i];
    		else arr[i] = (arr[i + 1] / arr[i]) * arr[i];
    	}	
    	return arr[0];
    	
    }