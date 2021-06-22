import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AlphabetAnimals {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String prev = scan.nextLine();
        int numNames = scan.nextInt();
        
        char last = prev.charAt(prev.length() - 1);
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        
        //Inserting
        for (int i = 0; i < numNames; i++) {
            String temp = scan.next();
            char cha = temp.charAt(0);
            if (!map.containsKey(cha)) {
                ArrayList<String> words = new ArrayList<>();
                words.add(temp);
                map.put(cha, words);
            }
            else {
                map.get(cha).add(temp);
            } 
        }
        
        if (!map.containsKey(last)) System.out.println("?");
        else {
            ArrayList<String> pos = map.get(last);
            boolean found = false;
            String found1 = "";
            boolean elim = false;
            String found2 = "";
            
            for (int i = 0; i < pos.size(); i++) {
                
                String word = pos.get(i);
                char front = word.charAt(0);
                char end = word.charAt(word.length() - 1);
                
                if (front == last && !found) {
                    found = true;
                    found1 = word;
                }
                if (front == last && !elim) {
                    if (!map.containsKey(end) || (map.get(end).size() == 1 && map.get(end).get(0).equals(word))) {
                        elim = true;
                        found2 = word;
                        break;
                    }
                }
            }
            
            if (elim) System.out.println(found2 + "!");
            else if (found) System.out.println(found1);
            else System.out.println("?");
        }
    }
}