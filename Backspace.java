import java.util.*;

public class Backspace
{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s  = scan.nextLine();
        
        StringBuilder string = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '<') stack.push(s.charAt(i));
            else if (s.charAt(i) == '<' && !stack.isEmpty()) stack.pop();
        }
        
        while (!stack.isEmpty()) string.append(stack.pop());
        System.out.println(string.reverse());
    }
}