import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
//题5 通信误码
//        信号传播过程中会出现一些误码，不同的数字表示不同的误码ID，取值范围为1-65535,用一个数组记录误码出现的情况。每个误码出现的次数代表误码频度，请找出记录中包含频度最高误码的最小子数组长度。
//        输入描述:误码总数目：取值范围为0-255 ,取值为0表示没有误码的情况。
//        误码出现频率数组：误码ID范围为1-65535，数组长度1-1000
//        输出描述：包含频率最高的误码最小子数组的长度
//        示例1
//        输入：  5
//        1 2 2 4 1
//        输出: 2
//        说明：频度最高的有1和2，频度是2(出现的次数都是2)。可以包含频度最高的记录数组是 [2 2] 和 [1 2 2 4 1] ，最短是[2 2] ，最小长度为2
//        示例 2
//        输入: 7
//        输出: 1 2 2 4 2 1 1
//        说明: 频度最高的是1 和2 。 最短的是 [2 2 4 2]
public class Number05 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int size = scanner.nextInt();
        int[] arr = new int[size];
        Map map = new HashMap();
        for (int i : arr) {
            i = random.nextInt(10);
            if(!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,(Integer)map.get(i)+1);
            }
        }
        int maxV = 0;
        int maxK = 0;
        for(Object entry:map.entrySet()){
            if(Integer.parseInt( entry.toString().split("=")[1])>maxV){
                maxV =Integer.parseInt( entry.toString().split("=")[1]);
                maxK = Integer.parseInt( entry.toString().split("=")[0]);
            }
        }
        System.out.println(maxK+":"+maxV);
    }
}
