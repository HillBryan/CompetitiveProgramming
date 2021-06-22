import java.util.Scanner;

public class MissingNumber {

    public static void main(String[]  args) {
        Scanner scan = new Scanner(System.in);
        
        int max = Integer.valueOf(scan.nextLine());
        String s = scan.nextLine();
        String found = null;
        
        for (int i = 0, j = 1; i < s.length(); j++) {
            String target = (j) + "";
            //System.out.println(target + " " + s.substring(i, target.length() + i));
            
            if (!s.substring(i, target.length() + i).equals(target)) {
                found = target;
                break;
            }
            
            i += target.length();
        }
        
        if (found == null) {
            System.out.println(max);
        }
        else {
            System.out.println(found);
        }
        
    }
}