import java.util.*;

public class TurtleMaster {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[][] board = new char[8][8];
        
        for (int i = 0; i < board.length; i++) {
            String row = scan.nextLine();
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        
        String moves = scan.nextLine();
        char direction = 'E';
        boolean broken = false;
        int row = 7;
        int col = 0;
        
        //Special case: Turtle goes in circle
        board[row][col] = '.';
        
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            //System.out.println(move + " " + direction + " " + row + " " + col);
            
            //Forward logic
            if (move == 'F') {
                if (!checkBounds(direction, row, col) || !checkMove(board, direction, row, col)) {
                    broken = true;
                    System.out.println("Bug!");
                    break;
                }
                else {
                    if (direction == 'E') col++;
                    else if (direction == 'W') col--;
                    else if (direction == 'N') row--;
                    else if (direction == 'S') row++;
                }
            }
            
            //Rotation logic
            else if (move == 'L' || move == 'R') {
                direction = rotate(direction, move);
            }
            
            //Laser logic
            else if (move == 'X') {
                if (!checkBounds(direction, row, col) || !checkFireTargets(board, direction, row, col)) {
                    broken = true;
                    System.out.println("Bug!");
                    break;
                }
                else {
                    if (direction == 'E') board[row][col + 1] = '.';
                    else if (direction == 'W') board[row][col - 1] = '.';
                    else if (direction == 'N') board[row - 1][col] = '.';
                    else if (direction == 'S') board[row + 1][col] = '.';
                }
            }
        }
        
        if (!broken && board[row][col] == 'D') System.out.println("Diamond!");
        else if (!broken && board[row][col] != 'D') System.out.println("Bug!");
        
    }
    
    public static boolean checkBounds(char direction, int row, int col) {
        if (direction == 'E' && col > 6) return false;
        if (direction == 'W' && col < 1) return false;
        if (direction == 'N' && row < 1) return false;
        if (direction == 'S' && row > 6) return false;
        return true;
    }
    
    public static boolean checkMove(char[][] board, char direction, int row, int col) {
        if (direction == 'E' && board[row][col + 1] != '.' && board[row][col + 1] != 'D') return false;
        if (direction == 'W' && board[row][col - 1] != '.' && board[row][col - 1] != 'D') return false;
        if (direction == 'N' && board[row - 1][col] != '.' && board[row - 1][col] != 'D') return false;
        if (direction == 'S' && board[row + 1][col] != '.' && board[row + 1][col] != 'D') return false;
        return true;
    }
    
    public static char rotate(char direction, char rType) {
        if (rType == 'R') {
            if (direction == 'E') return 'S';
            if (direction == 'S') return 'W';
            if (direction == 'W') return 'N';
            if (direction == 'N') return 'E';
        }
        else {
            if (direction == 'E') return 'N';
            if (direction == 'N') return 'W';
            if (direction == 'W') return 'S';
            if (direction == 'S') return 'E';
        }
        return '0';
    }
    
    public static boolean checkFireTargets(char[][] board, char direction, int row, int col) {
        if (direction == 'E' && board[row][col + 1] != 'I') return false;
        if (direction == 'W' && board[row][col - 1] != 'I') return false;
        if (direction == 'N' && board[row - 1][col] != 'I') return false;
        if (direction == 'S' && board[row + 1][col] != 'I') return false;
        return true;
    }  
}