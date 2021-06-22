import java.util.*;

public class RobotPathDecoding {

	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < t; i++) {
        	String path = scan.nextLine();
        	System.out.print("Case #" + (i + 1) +": ");
        	solve(decode(path));
        }
    }
	
	public static void solve(String path) {
		long x = 0;
		long y = 0;
		for (int i = 0; i < path.length(); i++) {
			char dir = path.charAt(i);
			if (dir == 'N') {
				y = ((y - 1) + 1000000000) % 1000000000;
			}
			else if (dir == 'S') {
				y = ((y + 1) + 1000000000) % 1000000000;
			}
			else if (dir == 'E') {
				x = ((x + 1) + 1000000000) % 1000000000;
			}
			else if (dir == 'W') {
				x = ((x - 1) + 1000000000) % 1000000000;
			}
		}
		System.out.println((x + 1) + " " + (y + 1));
	}
    
    public static String decode(String path) {
    	Stack<Character> moves = new Stack<>();
    	Stack<Character> nums = new Stack<>();
    	StringBuilder ret = new StringBuilder();
    	for (int i = 0; i < path.length(); i++) {
    		char cur = path.charAt(i);
    		if (cur == 'N' || cur == 'S' || cur == 'E' || cur == 'W' || cur == '(') moves.push(cur);
    		else if (cur - '0' > -1 && cur - '0' < 10) nums.push(cur);
    		else if (cur ==')') {
    			StringBuilder temp = new StringBuilder();
    			char pop = moves.pop();
    			while (pop != '(') {
    				temp.append(pop);
    				pop = moves.pop();
    			}
    			temp.reverse();
    			if (nums.size() != 0) {
    				int n = nums.pop() - '0';
    				for (int j = 0; j < n; j++) {
    					for (int k = 0; k < temp.length(); k++) {
    						moves.push(temp.charAt(k));
    					}
    				}
    			}
    		}
    	}
    	
    	while (moves.size() != 0) {
    		ret.append(moves.pop());
    	}
    	return ret.reverse().toString();
    }
}