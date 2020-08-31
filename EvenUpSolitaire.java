import java.util.*;

public class EvenUpSolitaire
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
       
        for (int i = 0; i < n; i++) {
            int val = scan.nextInt();
            if (!stack.isEmpty() && (stack.peek() + val)  % 2 == 0) stack.pop();
            else stack.push(val);
        }
        
        System.out.println(stack.size());
    }
}