package passExam;

import java.util.Scanner;

public class TestDemo12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int money = Integer.parseInt(firstLine.split(" ")[0]);
        int num = Integer.parseInt(firstLine.split(" ")[1]);
        int[] intArr = new int[(int) Math.pow(2, num)];
        int[][] listArr = new int[num][3];
        for (int i = 0; i < num; i++) {
            String tempStr = scanner.nextLine();
            int[] arr = new int[3];
            int tempPrice = Integer.parseInt(tempStr.split(" ")[0]);
            int tempPoint = Integer.parseInt(tempStr.split(" ")[1]);
            int tempQ = Integer.parseInt(tempStr.split(" ")[2]);
            arr[0] = tempPrice;
            arr[1] = tempPoint;
            arr[2] = tempQ;
            listArr[i] = arr;
        }
        boolean notEnd = true;
        int[] countArr = new int[num];
        int index_length = 0;
        while (notEnd) {
            if (isReasonable(countArr, money, listArr)) {
                int sumP = getSumPoint(countArr, listArr);
                intArr[index_length] = sumP;
                index_length++;
            }
            boolean followOver = true;
            int index = 0;
            while (followOver && index < countArr.length) {
                int iT = countArr[index] + 1;
                if (iT > 1) {
                    countArr[index] = 0;
                    index++;
                } else {
                    countArr[index] = iT;
                    followOver = false;
                }
            }
            notEnd = index < countArr.length;
        }
        int maxPoint = intArr[0];
        for (int i : intArr) {
            if (i > maxPoint) {
                maxPoint = i;
            }
        }
        System.out.println(maxPoint);
    }

    public static boolean isReasonable(int[] countArr, int money, int[][] listArr) {
        for (int i = 0; i < listArr.length; i++) {
            if (listArr[i][2] > 0 && countArr[i] == 1) {
                int id = listArr[i][2];
                countArr[id - 1] = 1;
            }
        }
        return getSumMoney(countArr, listArr) <= money;
    }

    public static int getSumMoney(int[] countArr, int[][] listArr) {
        int sumMoney = 0;
        for (int i = 0; i < listArr.length; i++) {
            sumMoney += countArr[i] * listArr[i][0];
        }
        return sumMoney;
    }

    public static int getSumPoint(int[] countArr, int[][] listArr) {
        int sumPoint = 0;
        for (int i = 0; i < countArr.length; i++) {
            sumPoint += countArr[i] * listArr[i][1] * listArr[i][0];
        }
        return sumPoint;
    }
}
