package passExam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class TestDemo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            int index = Integer.parseInt(line.split(" ")[0]);
            int value = Integer.parseInt(line.split(" ")[1]);
            if (hashMap.containsKey(index)) {
                hashMap.put(index, value + hashMap.get(index));
            } else {
                hashMap.put(index, value);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            int[] tempArr = new int[2];
            tempArr[0] = integer;
            tempArr[1] = hashMap.get(integer);
            list.add(tempArr);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return Integer.valueOf(ints[0]).compareTo(Integer.valueOf(t1[0]));
            }
        });
        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
