package passExam;

import java.util.Scanner;

public class TestDemo07 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
    }
}
