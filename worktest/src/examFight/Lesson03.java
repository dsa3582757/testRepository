package examFight;

import java.util.HashMap;
import java.util.Scanner;

public class Lesson03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str_16 = scanner.nextLine();
        System.out.println(get_10(str_16));
    }
    public static int get_10(String string){
        String str = string.substring(2);
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(String.valueOf(i),i);
        }
        String[] strArr = {"A","B","C","D","E","F"};
        for (int i = 0; i < strArr.length; i++) {
            hashMap.put(strArr[i],10+i);
        }
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += hashMap.get(String.valueOf(str.charAt(i))) * Math.pow(16,str.length()-i-1);
        }
        return sum;
    }
}
