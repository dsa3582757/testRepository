package test;

import java.util.Arrays;
import java.util.Scanner;
//题9- 知识图谱新词挖掘
//        小华负责公司知识图谱产品，现在要通过新词挖掘完善知识图谱
//        新词挖掘:给出一个待挖掘文本内容字符串 Content 和一个词的字符串word ,找到content中所有word的新词
//        新词:使用词word的字符排列形成的字符串
//        请帮小华实现新词挖掘，返回发现的新词的数量
//        输入描述:第一行输入为待挖掘的文本内容content；第二行输入为词word;
//        输出描述：在content中找到的所有word的新词的数量
//        补充说明:0<=content的长度<=10000000 ; 1<= word的长度<=2000
//        示例：
//        输入 : qweebaewqd
//        Qwe
//        输出: 2
//        说明：起始索引等于0的子串是”qwe” ，它是word的新词。起始索引等于6的子串是 “ewq”,它是word的新词
public class Number09 {

    public static boolean strEquals(String a,String b){
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        Arrays.sort(arrA);
        String strA = "";
        for (char c : arrA) {
            strA = strA + c;
        }
        Arrays.sort(arrB);
        String strB = "";
        for (char c : arrB) {
            strB = strB + c;
        }
        if(strA.equals(strB)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String word = scanner.nextLine();
        int size = word.length();
        int sum = 0;
        for(int i = 0;i <=str.length() - size;i++){
            String tmpStr = str.substring(i,i+size);
            if(strEquals(tmpStr,word)){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
