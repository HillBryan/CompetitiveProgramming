import java.util.Scanner;

public class Natrij {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String currentTime = scan.nextLine();
        String finalTime = scan.nextLine();
        
        String format1[] = currentTime.split(":");
        String format2[] = finalTime.split(":");
        
        int value1 = 0;
        int value2 = 0;
        
        value1 += Integer.valueOf(format1[2]);
        value2 += Integer.valueOf(format2[2]);
        
        value1 += Integer.valueOf(format1[1]) * 60;
        value2 += Integer.valueOf(format2[1]) * 60;
        
        value1 += Integer.valueOf(format1[0]) * 60 * 60;
        value2 += Integer.valueOf(format2[0]) * 60 * 60;
        
        if (value1 > value2) {
            int value3 = (24 * 60 * 60) - value1 + value2;
            int hours = value3 / (60 * 60);
            value3 %= (60 * 60);
            int mins = value3 / 60;
            int seconds = value3 % 60;
            
            String Hours = "";
            String Mins = "";
            String Seconds = "";
            
            Hours = (hours < 10) ? "0" + hours : hours + "";
            Mins = (mins < 10) ? "0" + mins : mins + "";
            Seconds = (seconds < 10) ? "0" + seconds : seconds + "";
            
            
            System.out.println(Hours + ":" + Mins + ":" + Seconds);
        }
        else if (value2 > value1) {
            int value3 = value2 - value1;
            int hours = value3 / (60 * 60);
            value3 %= (60 * 60);
            int mins = value3 / 60;
            int seconds = value3 % 60;
            
            String Hours = "";
            String Mins = "";
            String Seconds = "";
            
            Hours = (hours < 10) ? "0" + hours : hours + "";
            Mins = (mins < 10) ? "0" + mins : mins + "";
            Seconds = (seconds < 10) ? "0" + seconds : seconds + "";
            
            
            System.out.println(Hours + ":" + Mins + ":" + Seconds);
        }
        else System.out.println("24:00:00");
    }
}