import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ICanGuessTheDataStructure {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while (scan.hasNext()) {
            
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
            
            String result = "";
            boolean qRes = true;
            boolean sRes = true;
            boolean pRes = true;
            
            int m = scan.nextInt();
            
            for (int i = 0; i < m; i++) {
                int type = scan.nextInt();
                int value = scan.nextInt();
                
                if (type == 1) {
                    queue.add(value);
                    stack.push(value);
                    pQ.add(value);
                    
                }
                
                else {
                    result += value;
                    if (queue.isEmpty() || queue.poll() != value) qRes = false;
                    if (stack.isEmpty() || stack.pop() != value) sRes = false;
                    if (pQ.isEmpty() || pQ.poll() != value) pRes = false;
                } 
            }
            
            if ((qRes && sRes && pRes) || (qRes && sRes) || (qRes && pRes) || (sRes && pRes)) System.out.println("not sure");
            else if (!qRes && !sRes && !pRes) System.out.println("impossible");
            else if (qRes) System.out.println("queue");
            else if (sRes) System.out.println("stack");
            else System.out.println("priority queue");
        } 
    }
}