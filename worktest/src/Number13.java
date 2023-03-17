import java.util.ArrayList;
import java.util.Scanner;
//题13 - 查找充电设备组合
//        某个充电站，可提供n 个 充电设备，每个充电设备均有对应的输出功率。任意个充电设备组合的输出功率总和，均构成功率集合P的1个元素。功率集合P的最优元素，表示最接近充电站最最大输出功率p_max的元素。
//        输入描述：
//        输入为3行：
//        第1行为充电设备个数n
//        第2行为每个充电设备的输出功率。
//        第3行为充电站最大输出功率p_max。
//        输出描述：
//        功率集合P的最优元素
//        补充说明：
//        1.充电设备个数 n>0
//        2.最优元素必须小于或等于充电站最大输出功率p_max
//        示例：
//        输入：
//        4
//        50 20 20 60
//        90
//        说明：
//        当充电设备输出功率 50、20、20组合时，其输出功率总和为90，最接近充电站最大充电输出功率，因此最优元素为90。
//        示例：
//        输入：
//        2
//        50 40
//        30
//        输出：
//        0
//        说明：
//        所有充电设备的输出功率组合，均大于充电站最大充电输出功率，因此最优元素为0
public class Number13 {
    public static int getResult(ArrayList<int[]> list, int maxPower){
        int differ = maxPower;
        int listCount = list.size();
        for (int[] ints : list) {
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += ints[i];
            }
            if(sum>maxPower){
                listCount--;
            } else {
                if(maxPower-sum<differ){
                    differ = maxPower-sum;
                }
            }
        }
        if(listCount==1){
            return 0;
        }else {
            return maxPower-differ;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String powerStr = scanner.nextLine();
        int maxPower = Integer.parseInt(scanner.nextLine());
        String[] powerStrArr = powerStr.split(" ");
        int[] powerArr = new int[powerStrArr.length];
        int[] countArr = new int[powerArr.length];
        for (int i = 0; i < powerStrArr.length; i++) {
            powerArr[i] = Integer.parseInt(powerStrArr[i]);
            countArr[i] = 0;
        }
        ArrayList list = new ArrayList<int[]>();
        boolean notEnd = true;
        while (notEnd){
            int[] tmpArr = new int[powerStrArr.length];
            for (int i = 0; i < tmpArr.length; i++) {
                tmpArr[i] = countArr[i]*powerArr[i];
            }
            list.add(tmpArr);
            int index = 0;
            boolean flowOver = true;
            while (flowOver && index < powerArr.length){
                int iT = countArr[index] + 1;
                if(iT>1){
                    countArr[index] = 0;
                    index++;
                } else {
                    countArr[index] = iT;
                    flowOver = false;
                }
            }
            notEnd = index < powerArr.length;
        }
        System.out.println(getResult(list,maxPower));
    }
}
