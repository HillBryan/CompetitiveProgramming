import java.util.Scanner;

public class Ones {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        try {
            while (scan.hasNextLine()) {
                
                
                int div = scan.nextInt();
                long val = 1;
                long length = 1;
                boolean done = false;
                
                
                while (!done) {
                    if (val % div == 0) done = true;
                    else { 
                        val = (val * 10 + 1) % div;
                        length++;
                    }
                }
    
                System.out.println(length);
            }
        }
        catch (Exception e) {};
    }