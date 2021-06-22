import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UnreadMessages {

    public static void main(String[]  args) {
        Scanner scan = new Scanner(System.in);
        
        String[] in = scan.nextLine().split(" ");
        int n = Integer.valueOf(in[0]);
        int m = Integer.valueOf(in[1]);
        
        int untouched = n;
        int person = 0;
        HashSet<Integer> seen = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            int sender = Integer.valueOf(scan.nextLine());
            BigInteger found = new BigInteger("0");
            if (!seen.contains(sender)) {
                untouched--;
            }
            person++;
            
            //Updating map and set
            seen.add(sender);
            if (map.containsKey(sender)) {
                map.replace(sender, 0);
            }
            else {
                map.put(sender, 0);
            }
            
            for (Integer p : seen) {
                if (p != sender) {
                    map.replace(p, map.get(p) + 1);
                    found = found.add(BigInteger.valueOf((map.get(p))));
                }
            }
            BigInteger mult = new BigInteger(untouched + "");
            mult = mult.multiply(BigInteger.valueOf(person));
            found = found.add(mult);
            System.out.println(found);
        }
    }
}
