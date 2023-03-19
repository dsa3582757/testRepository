package test;

import java.util.Scanner;
//题10 - 最左侧冗余覆盖子串
//        题目描述: 给定2个字符串s1和s2和正整数k,其中s1长度为n1,s2的长度为n2
//        在s2中选一个子串，满足:
//        该子串长度为n1 +k
//        该子串包含s1的全部字母
//        该子串每个字母的出现次数不小于s1中对应的字母
//        我们称s2以长度k冗余覆盖s1。给定s1,s2和k,求最左侧的s2以长度冗余覆盖s1的子串的首个元素的下标，如果没有返回-1
//        举例:
//        s1=ab
//        S2 = aabcd
//        K =1
//        则子串aab和abc均满足此条件，由于aab在abc的左侧，aab的第一个元素下标为0，因此输出0
//        输入描述:输入三行，第一行为s1,第二行为s2,第三行为k
//        s1和s2只包含小写字母
//        输出描述: 最左侧的s2以长度k冗余覆盖s1的子串首个元素的下标，如果没有返回-1
//        补充说明: 0<= len(s1) <= 1000000 , 0<= len(s2)<= 2000000 ,0<=k<=1000
//        示例1：
//        输入:
//        ab
//        aabcd
//        1
//        输出: 0
//        说明：子串aab和abc满足要求，由于aab在abc的左侧，因此输出aab的下下标:0
public class Number10 {
    public static int charNum(String s,char ch){
        char[] arr = s.toCharArray();
        int sum = 0;
        for (char c : arr) {
            if(c==ch){
                sum++;
            }
        }
        return sum;
    }
    public static boolean strContain(String a,String b){
        boolean result = true;
        char[] arrA = a.toCharArray();
        for (char c : arrA) {
            if(!(b.contains(String.valueOf(c))&& charNum(a,c)<=charNum(b,c))){
                result = false;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int k = scanner.nextInt();
        int n1 = s1.length();
        int n2 = s2.length();
        int result = -1;
        for (int i = 0; i <=  n2 - n1 - k ; i++) {
            String strTmp = s2.substring(i,i+n1+k);
            if(strContain(s1,strTmp)){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
