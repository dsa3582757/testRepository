package examFight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(scanner.nextLine());
            list.add(temp);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : list) {
            if (!arrayList.contains(integer)) {
                arrayList.add(integer);
            }
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        });
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }
}
