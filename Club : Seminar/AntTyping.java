import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AntTyping
{
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        
        int[][] transitions = new int[10][10];
        fillTransitions(input, transitions);
       
        
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        //Finding all permutations
        System.out.println(heapPermutation(nums, transitions, nums.length, nums.length, input.charAt(0) - '0'));
    }
    
    public static void fillTransitions(String input, int[][] transitions) {
        
        for (int i = 0; i < input.length() - 1; i++) {
            int s = input.charAt(i) - '0';
            int t = input.charAt(i + 1) - '0';
            transitions[s][t]++;
        }
    }
    
    // Generating permutation using Heap Algorithm
    // Source: https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
    public static int heapPermutation(int a[], int[][] transitions, int size, int n, int first)
    {
        
        int min = Integer.MAX_VALUE;
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            return caculateTime(a, transitions, first);
        }
 
        for (int i = 0; i < size; i++) {
            min = Math.min(min, heapPermutation(a, transitions, size - 1, n, first));
 
            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }
 
            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
        return min;
    }
    
    public static int caculateTime(int[] board, int[][] transitions, int first) {
        
        int time = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < board.length; i++) {
            map.put(board[i], i);
        }
        
        for (int i = 0; i < transitions.length; i++) {
            for (int j = 0; j < transitions[i].length; j++) {
                if (transitions[i][j] > 0) {
                    int distance = Math.abs(map.get(i) - map.get(j));
                    time += ((distance + 1) * transitions[i][j]);
                }
            }
        }
        return time + map.get(first) + 1;
    }

}
