import java.util.*;

public class Yoda {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s1 = scan.nextInt() + "";
        String s2 = scan.nextInt() + "";
        
        int maxLength = s1.length() > s2.length() ? s1.length() : s2.length();
        
        StringBuilder top = new StringBuilder(padZeroes(s1, maxLength));
        StringBuilder bottom = new StringBuilder(padZeroes(s2, maxLength));
        
        
        for (int i = 0; i < top.length() && i < bottom.length(); i++) {
            if ((top.charAt(i) - '0') - (bottom.charAt(i) - '0') > 0) {
                bottom.setCharAt(i, 'D');
            }
            else if ((bottom.charAt(i) - '0') - (top.charAt(i) - '0') > 0) {
                top.setCharAt(i, 'D');
            }
        }
        
        String fin1 = "";
        String fin2 = "";
        
        for (int i = 0; i < top.length() && i < bottom.length(); i++) {
            if (top.charAt(i) != 'D') fin1 += top.charAt(i);
            if (bottom.charAt(i) != 'D') fin2 += bottom.charAt(i);
        }
        
        if (fin1.length() == 0) System.out.println("YODA");
        else System.out.println(Integer.valueOf(fin1));
        
        if (fin2.length() == 0) System.out.println("YODA");
        else System.out.println(Integer.valueOf(fin2));
        
    }
    
    public static String padZeroes(String s, int length) {
        while (s.length() != length) {
            s = "0" + s;
        }
        return s;
    }
}