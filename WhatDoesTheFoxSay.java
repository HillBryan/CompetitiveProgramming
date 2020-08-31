import java.util.*;

public class WhatDoesTheFoxSay {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int testCases = Integer.valueOf(scan.nextLine());
        
        for (int t = 0; t < testCases; t++) {
            String[] phrase = scan.nextLine().split(" ");
            HashSet<String> set = new HashSet<>();
            for (String s : phrase) set.add(s);
            
            String next = scan.nextLine();
            while (!next.equals("what does the fox say?")) {
                String[] splitNext = next.split(" ");
                set.remove(splitNext[2]);
                next = scan.nextLine();
            }
            
            String ret = "";
            for (String s : phrase) {
                if (set.contains(s)) ret += (s + " ");
            }
            
            System.out.println(ret);
        }
        
    }
}