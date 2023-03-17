import java.util.Scanner;
//题11-数组的中心位置
//        题目描述:给你一个整数组nums，请计算数组的中心位置。数组中心位置是数组的一个的一个下标，其左侧所有元素相乘的积等于右侧所有元素相乘的积。
//        数组第一个元素的左侧积为1，最后一个元素的右侧积为1
//        如果数组有多个中心位置，应该返回最靠近左边的的那一个。如果数组不存在中心位置，返回-1
//        输入描述：输入只有一行，给出N个正整数用空格分隔，nums = 2 5 3 6 5 6
//        1<= num.length<=1024
//        1<=num[i] <=10
//        输出描述：输出：3
//        解释：中心位置是3 。左侧数之积sum = num[0]*num[1]*num[2] = 2*5*3 = 30
//        右侧数之积 sum = num[4]*num[5] = 5*6 = 30,二者相等。
//        示例1：
//        输入: 2 5 3 6 5 6
//        输出: 3
public class Number11 {
    public static int product(char[] chars) {
        int sum = 1;
        if (chars.length == 0) {
            return sum;
        }
        for (char s : chars) {
            sum = sum * Integer.parseInt(String.valueOf(s));
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        String strF = str.replaceAll(" +","");
        int sumFront;
        int sumAfter;
        int score = -1;
        for (int i = 0; i < arr.length; i++) {
            String strFront = strF.substring(0, i);
            String strAfter = strF.substring(i + 1, arr.length);
            if (i == 0) {
                sumFront = 1;
            } else {
                sumFront = product(strFront.toCharArray());
            }
            if (i == arr.length - 1) {
                sumAfter = 1;
            } else {
                sumAfter = product(strAfter.toCharArray());
            }
            if (sumFront == sumAfter) {
                score = i;
                break;
            }
        }
        System.out.println(score);
    }
}
