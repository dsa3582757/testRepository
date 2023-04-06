package passExam;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayList<Integer> list = getNum(a);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static ArrayList<Integer> getNum(int a) {
        ArrayList<Integer> list = new ArrayList<>();
        if (a == 1) {
            return list;
        } else {
            Integer num = (int) Math.sqrt(a);
            for (int i = 2; i <= num; i++) {
                while (a % i == 0) {
                    list.add(i);
                    a = a / i;
                }
            }
            if (a != 1) {
                list.add(a);
            }
        }
        return list;
    }

    public static boolean isZhi(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        }
        boolean result = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
