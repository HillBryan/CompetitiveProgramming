import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class KittenOnATree {
    
    static String ok = "";
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = Integer.valueOf(scan.nextLine());
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] point = new int[101];
        HashSet<Integer> set = new HashSet<>();
        String input = "";
        
        while (!(input = scan.nextLine()).equals("-1")) {
            String[] split = input.split(" ");
            int root = Integer.valueOf(split[0]);
            set.add(root);
            map.put(root, new ArrayList<Integer>());
            for (int i = 1; i < split.length; i++) {
                map.get(root).add(Integer.valueOf(split[i]));
                point[Integer.valueOf(split[i])]++;
                set.add(Integer.valueOf(split[i]));
            }
        }
        int root = 0;
        for (int i = 1; i < 101; i++) {
            if (point[i] == 0 && set.contains(i)) {
                root = i;
                break;
            }
        }
        ArrayList<Integer> t = new ArrayList<>();
        t.add(root);
        map.put(500, t);
        dfs(500, map, target, "");
        System.out.println(ok.trim());
    }
    
    public static void dfs(int root, HashMap<Integer, ArrayList<Integer>> map, int target, String path) {
        if (root == target && ok.length() == 0) ok = path;
        if (map.containsKey(root)) {
            for (Integer i : map.get(root)) {
                dfs(i, map, target, i + " " + path);
            }
        }
    }
}