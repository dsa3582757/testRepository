package passExam;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();
        String numStr = num.toString();
        StringBuilder stringBuilder = new StringBuilder(numStr);
        stringBuilder.reverse();
        String finalStr = new String(stringBuilder);
        char[] chars = finalStr.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            if (!list.contains(aChar)) {
                list.add(aChar);
            }
        }
        String str = new String();
        for (Character character : list) {
             str = str.concat(character.toString());
        }
        System.out.println(str);
    }
}
