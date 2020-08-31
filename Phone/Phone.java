import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Phone
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        
        for (int l = 0; l < cases; l++) {
            int nums = scan.nextInt();
            
            HashMap<Integer, ArrayList<String>> map = new HashMap<>();
            HashSet<Integer> len = new HashSet<>();
            
            
            //Inserting
            for (int i = 0; i < nums; i++) {
                String number = scan.next();
                len.add(number.length());
                
                if (!map.containsKey(number.length())) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(number);
                    map.put(number.length(), list);
                }
                else {
                    ArrayList<String> list = map.get(number.length());
                    list.add(number);
                    map.replace(number.length(), list);
                }
            }
            
            //Sorting by length
            Object[] lens = len.toArray();
            Arrays.sort(lens);
            
            boolean ok = true;
            
            //Building Tree
            
            OverlayTree tree = new OverlayTree();
            
            for (int i = lens.length - 1; i > -1; i--) {
                ArrayList<String> pNums = map.get(lens[i]);
                for (String num : pNums) {
                    if (!tree.insert(num)) {
                        ok = false;
                        i = -1;
                    }
                }
            }
            
            
            //Print answer
            if (ok) System.out.println("YES");
            else System.out.println("NO");
        } 
    }
}
