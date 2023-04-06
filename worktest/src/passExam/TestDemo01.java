package passExam;

import java.util.Scanner;

public class TestDemo01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String wd = scanner.nextLine();
        String rwd = reverse(wd);
        int num = 0;
        for (int i = 0; i < words.length(); i++) {
            String temp = String.valueOf(words.charAt(i));
            if(wd.equals(temp)||rwd.equals(temp)){
                num+=1;
            }
        }
        System.out.println(num);
    }

    public static String reverse(String wd){
        int a = wd.charAt(0);
        if (a>=65 && a<=90){
            return wd.toLowerCase();
        } else if (a>=97&&a<=122) {
            return wd.toUpperCase();
        }
        return wd;
    }
}
