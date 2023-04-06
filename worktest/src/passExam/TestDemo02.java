package passExam;

import java.util.Scanner;

public class TestDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            out8(str);
        }
    }

    public static void out8(String string) {
        int num = string.length();
        int size;
        int lastLength;
        if (num >= 8 && num % 8 == 0) {
            size = num/8;
            for (int i = 0; i < size; i++) {
                System.out.println(string.substring(i*8,(i+1)*8));
            }
        } else if (num < 8) {
            size = 1;
            lastLength = 8;
            System.out.println(add0(string, 8 - num));
        } else {
            size = num/8+1;
            for (int i = 0; i < size-1; i++) {
                System.out.println(string.substring(i*8,(i+1)*8));
            }
            System.out.println(add0(string.substring((size-1)*8,num), 8 - num % 8));
        }
    }

    public static String add0(String string, int n) {
        String result = string;
        while (n > 0) {
            result = result.concat("0");
            n--;
        }
        return result;
    }
}
