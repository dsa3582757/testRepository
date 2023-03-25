package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Question02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String strNum = scanner.nextLine();
        String[] strArr = strNum.split(" ");
        int[] numArr = new int[num];
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < num; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        for (int i = 0; i < num; i++) {
            int[] tmp = new int[2];
            tmp[0]=numArr[i];
            int allNum = 0;
            for (int j = 0; j < num; j++) {
                allNum += Math.abs(numArr[j]-numArr[i]);
            }
            tmp[1] = allNum;
            list.add(tmp);
        }
        int minAllLength = list.get(0)[1];
        int minLength=0;
        for (int i = 0; i < list.size(); i++) {
            if(minAllLength>list.get(i)[1]){
                minAllLength = list.get(i)[1];
                minLength = list.get(i)[0];
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(minAllLength==list.get(i)[1]&&minLength>list.get(i)[0]){
                minLength = list.get(i)[0];
            }
        }
        System.out.println(minLength);
    }

}
