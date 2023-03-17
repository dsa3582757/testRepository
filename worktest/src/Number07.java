import java.util.Scanner;
//题7 - 箱子之型摆放
//        有一批箱子(形式为字符串，设为str ) 要求将这批箱子按从上到下以之形的顺序摆放在宽度为n的空地，请输出箱子的摆放结果。例如：箱子为ABCDEFG,空地宽度为3，摆放结果如图:
//        A	F	G
//        B	E
//        C	D
//        则输出结果为:
//        AFG
//        BE
//        CD
//        输入描述:输入一行字符串，通过空格分割，前面部分为字母或数字组成的字符串str，表示箱子，后面部分为一个数字n，表示空地的宽度。例如:ABCDEFG 3
//        输出描述:箱子摆放结果，如题目示例所示
//        AFG
//        BE
//        CD
//        补充说明：
//        1.请不要在最后一行输出额外的空行
//        2.Str只包含字母和数字，1<=len(str) <= 1000
//        3.1<=n<=1000

public class Number07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s = str.split(" ")[0];
        int n = Integer.parseInt(str.split(" ")[1]);
        char[] arr = s.toCharArray();
        int size;
        if (arr.length % n == 0) {
            size = arr.length / n;
        } else {
            size = arr.length / n + 1;
        }
        String[] strArr = new String[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            int num = count + n - 1;
            if (count + n > arr.length) {
                num = arr.length - 1;
            }
            String strTmp = s.substring(count, num + 1);
            count = count + n;
            strArr[i] = strTmp;
        }
        String[] strFin = new String[n];
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < strArr.length; j++) {
                if (i + 1 <= strArr[j].length()) {
                    tmp = tmp + strArr[j].charAt(i);
                }
            }
            strFin[i] = tmp;
            System.out.println(tmp);
        }
    }
}
