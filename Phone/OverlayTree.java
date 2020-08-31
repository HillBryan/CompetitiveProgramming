public class OverlayTree {
        
        Node head;
        
        public OverlayTree() {
            head = new Node(' ');
        }
        
        public boolean insert(String num) {
            Node tempHead = head;
            char[] nums = num.toCharArray();
            boolean ret = false;
            
            for (Character c : nums) {
                boolean found = false;
                for (Node child : tempHead.childern) {
                    if (child.character == c) {
                        tempHead = child;
                        found = true;
                        break;
                    }  
                }
                if (!found) {
                    Node temp = new Node(c);
                    tempHead.childern.add(temp);
                    tempHead = temp;
                    ret = true;
                }
            }
            return ret;
        }
    }