import java.util.*;

public class SumOfTheOthers {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while (scan.hasNextLine()) {
            String[] split = scan.nextLine().split(" ");
            int[] nums = new int[split.length];
            
            int total = 0;
            
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.valueOf(split[i]);
                total += nums[i];
            }
            
            for (Integer num : nums) {
                if (total - num == num) {
                    System.out.println(num);
                    break;
                }
            } 
        } 
    }
}