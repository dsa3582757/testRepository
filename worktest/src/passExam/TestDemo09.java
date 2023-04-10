package passExam;

import java.util.Scanner;

public class TestDemo09 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        String[] newStrArr = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            newStrArr[i] = strArr[strArr.length-i-1];
            System.out.print(newStrArr[i]+" ");
        }
    }
}
