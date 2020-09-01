import java.util.*;

public class Set {
    
    public static class Pair {
        String card;
        int index;
        
        public Pair(String card, int index) {
            this.card = card;
            this.index = index;
        }
    }

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        //Generate all possible groups of three.
        //Validate each group of three.
        
        ArrayList<Pair> cards = new ArrayList<>();
        
        int index = 1;
        for (int i = 0; i < 4; i++) {
            String[] cardRow = scan.nextLine().split(" ");
            for (String card : cardRow) {
                cards.add(new Pair(card, index));
                index++;
            }
        }
        
        int sets = 0;
        if (cards.size() >= 3) {
            for (int i = 0; i < cards.size(); i++) {
                for (int j = i + 1; j < cards.size(); j++) {
                    for (int k = j + 1; k < cards.size(); k++) {
                        if (validate(cards.get(i).card, cards.get(j).card, cards.get(k).card)) {
                            System.out.println(cards.get(i).index + " " + cards.get(j).index + " " + cards.get(k).index);
                            sets++;
                        }
                    }
                }
            }
        }
        if (sets == 0) System.out.println("no sets");
    }
    
    public static boolean validate(String c1, String c2, String c3) {
        //All features must be the same or completely different
        for (int i = 0; i < 4; i++) {
            char one = c1.charAt(i);
            char two = c2.charAt(i);
            char three = c3.charAt(i);
            if ((one == two && two != three) || (one != two && two == three) || (one == three && one != two)) return false;
        }
        return true;
    }
}