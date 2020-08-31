import java.util.*;

public class Countdown
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
        	int n = scan.nextInt();
        	int k = scan.nextInt();
        	int[] ok = new int[n];
        	for (int j = 0; j < n; j++) {
        		ok[j] = scan.nextInt();
        	}
        	System.out.println("Case #" + (i + 1) + ": " + solve(ok, k));
        }
    }
    
    public static int solve(int[] arr ,int k) {
    	int count = 0;
    	for (int i = arr.length - 1; i > -1; i--) {
    		if (arr[i] == 1) {
    			int cc = 1;
    			while (i > -1 && arr[i] == cc) {
    				i--;
    				cc++;
    				if ((cc - 1) == k) {
    					count++;
    					break;
    				}
    			}
    			i++;
    		}
    	}
    	return count;
    }