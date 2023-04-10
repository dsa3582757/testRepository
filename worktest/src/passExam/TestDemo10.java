package passExam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TestDemo10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String temp = scanner.nextLine();
            stringArrayList.add(temp);
        }
        stringArrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        for (String s : stringArrayList) {
            System.out.println(s);
        }
    }
}
