import java.util.ArrayList;

public class Node {
        
        ArrayList<Node> childern;
        char character;
        public Node(char character) {
            childern = new ArrayList<>();
            this.character = character;
        }
 }