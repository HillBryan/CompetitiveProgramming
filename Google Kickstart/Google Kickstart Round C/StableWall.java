import java.util.*;

public class StableWall
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < t; i++) {
        	String[] s = scan.nextLine().split(" ");
        	int r = Integer.valueOf(s[0]);
        	int c = Integer.valueOf(s[1]);
        	char[][] board = new char[r][c];
        	for (int j = 0; j < r; j++) {
        		String o = scan.nextLine();
        		for (int k = 0; k < o.length(); k++) {
        			board[j][k] = o.charAt(k);
        		}
        	}
        	System.out.println("Case #" + (i + 1) + ": " + solve(board, r, c));
        }
    }
    
    public static String solve(char[][] board, int r, int c) {
    	//Approach go by vertical row, sorting by what came first
    	HashSet<Character> seen = new HashSet<>();
    	ArrayList<Character> order = new ArrayList<>();
    	for (int i = 0; i < c; i++) {
    		char last = '#';
    		for (int j = r - 1; j > -1; j--) {
    			if (!seen.contains(board[j][i])) {
    				seen.add(board[j][i]);
    				order.add(board[j][i]);
    			}
    			else if (seen.contains(board[j][i]) && last != '#'){
    				//Move prv to before cur
    				int cur = order.indexOf(board[j][i]);
    				int prv = order.indexOf(last);
    				//System.out.print("BEFORE: " + order.toString());
    				if (prv > cur) {
    					order.remove(prv);
        				if (cur == 0) order.add(0, last);
        				else order.add(cur, last);
    				}
    				//System.out.println(" AFTER: " + order.toString() + " PREV: " + prv + " CUR: " + cur + " BOARD: " + board[j][i] + " LAST: " + last);
    				
    			}
    			last = board[j][i];
    		}
    	}
    	
    	//Check order
    	for (int i = 0; i < c; i++) {
    		char last = '#';
    		for (int j = r - 1; j > -1; j--) {
    			if (last != '#') {
    				if (order.indexOf(last) > order.indexOf(board[j][i])) return "-1";
    			}
    			last = board[j][i];
    		}
    	}
    	
    	String ret = "";
    	for (Character cc : order) ret += cc;

    	return ret;
    }