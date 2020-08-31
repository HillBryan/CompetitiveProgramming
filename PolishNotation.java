import java.util.*;
public class PolishNotation {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int j = 0;
        
        while (scan.hasNext() && j < 5) {
            j++;
            String s = scan.nextLine();
            String[] split = s.split(" ");
            Stack<String> stack = new Stack<>();
            
            for (int i = split.length - 1; i > -1; i--) {
                String c = split[i];
                if (c.equals("+") || c.equals("-") || c.equals("*") && stack.size() > 1) {
                    String pop1 = stack.pop();
                    String pop2 = stack.pop();
                    if (isNumber(pop1) && isNumber(pop2)) {
                        int p1 = Integer.valueOf(pop1);
                        int p2 = Integer.valueOf(pop2);
                        if (c.equals("+")) stack.push(p1 + p2 + "");
                        else if (c.equals("-")) stack.push(p1 - p2 + "");
                        else if (c.equals("*")) stack.push(p1 * p2 + "");
                        else {
                            stack.push(pop2);
                            stack.push(pop1);
                        }
                    }
                    else {
                        stack.push(pop2);
                        stack.push(pop1);
                        stack.push(c);
                    }
                }
                else stack.push(c);
            }
            
            System.out.print("Case " + j + ": ");
            
            while (!stack.isEmpty() && stack.size() != 1) {
                System.out.print(stack.pop() + " ");
            }
            
            if (stack.size() == 1) System.out.print(stack.pop());
            System.out.println();
        }
    }
    
    public static boolean isNumber(String s) {
        try {
            int x = Integer.valueOf(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}