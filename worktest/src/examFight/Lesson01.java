package examFight;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp != 0) {
                list.add(temp);
            } else {
                break;
            }
        }
        for (Integer integer : list) {
            System.out.println(getNum(integer, true));
        }
    }

    public static int getNum(int n, boolean isFirst) {
        int result = 0;
        if (n == 1) {
            return 0;
        } else {
            if (isFirst) {
                if (n + 1 >= 3) {
                    result = (n + 1) / 3 + getNum((n + 1) / 3 + (n + 1) % 3, false);
                } else {
                    return 0;
                }
            } else {
                if (n >= 3) {
                    result = n / 3 + getNum(n / 3 + n % 3, false);
                } else {
                    return 0;
                }
            }
        }
        return result;
    }
}
