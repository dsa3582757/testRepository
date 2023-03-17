import java.util.ArrayList;
import java.util.Scanner;
//题12 -云短信平台优惠活动
//        题目描述:某云短信厂商，，为庆祝国庆，推出充值优惠活动
//        现在给出客户预算，和优惠售价序列，求最多可获得的短信总条数
//        输入描述：第一行客户预算M，其中0<=M<= 1000000
//        第二行给出售价表，P1,P2...Pn，其中 1<=n<=100，Pi为充值i元获得的短信条数。
//        1<=Pi<1000, 1<=n<100 输出描述：最多获得的短信条数
//        示例：
//        输入 ：6
//        10 20 30 40 60
//        输出： 70
//        说明：分两次充值最优，1元、5元各充一次。总条数 10 + 60 = 70
public class Number12 {
    public static int productKeyValue(int[] count, int[] price) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum + count[i] * price[i];
        }
        return sum;
    }

    public static boolean hasCorrect(int[] count, int[] price, int sum) {
        return productKeyValue(count, price) == sum;
    }

    public static int maxSum(ArrayList<int[]> list, int[] numArr){
        int max = 0;
        for (int[] ints : list) {
            int sum=0;
            for (int i = 0; i < numArr.length; i++) {
                sum = sum + ints[i] * numArr[i];
            }
            if(max<sum){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine());
        String form = scanner.nextLine();
        String[] strArr = form.split(" ");
        int[] numArr = new int[strArr.length];
        int[] countArr = new int[strArr.length];
        int[] priceArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
            priceArr[i] = i + 1;
            countArr[i] = 0;
        }
        ArrayList list = new ArrayList<int[]>();
        int sum = money;
        boolean notEnd = true;
        while (notEnd) {
            if(hasCorrect(countArr,priceArr,sum)){
                int[] tmpArr = new int[countArr.length];
                for (int i = 0; i < countArr.length; i++) {
                    tmpArr[i] = countArr[i];
                }
                list.add(tmpArr);
            }
            boolean flowOver = true;
            int index = 0;
            while (flowOver && index<countArr.length){
                int iT = countArr[index] + 1;
                if(iT > sum/priceArr[index]){
                    countArr[index]= 0;
                    index++;
                } else {
                    countArr[index] = iT;
                    flowOver = false;
                }
            }
            notEnd = index<countArr.length;
        }
        System.out.println(maxSum(list,numArr));
    }
}
