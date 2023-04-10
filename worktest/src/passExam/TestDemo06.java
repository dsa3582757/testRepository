package passExam;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            int i = aChar;
            if (!list.contains(aChar) && i >= 0 && i <= 127) {
                list.add(aChar);
            }
        }
        System.out.println(list.size());
    }
}
