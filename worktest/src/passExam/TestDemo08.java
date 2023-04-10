package passExam;

import java.util.Scanner;

public class TestDemo08 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}
