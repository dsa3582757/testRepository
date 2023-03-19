package test;

import java.util.Scanner;

public class Number03 {
//    小明在学习二进制时，发现了一类不含101的数，也就是:将数字用二进制表示，不能出现101
//    现在给定一个正区间[l,r] 请问这个区间内包含了多少个不含101的数？
//    输入描述:
//    输入的唯一一行包含两个正整数 l,r (1<=l<r<=109)
//    输出描述:
//    输出的唯一一行包含一个整数，表示在[l,r] 区间内一共有几个不含101的数。
    private static String transfer(int i){
        int []  arr= new int[32];
        int count = 0;
        while(i>0){
            arr[31-count] = i % 2;
            i = i/2;
            count++;
        }
        String  string = "";
        for (int i1 : arr) {
            string = string + String.valueOf(i1);
        }
        return string;
    }
    public static void main (String[]args){
        Scanner scanner =  new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = 0;
        for (int i = a; i <=b ; i++) {
            if(!transfer(i).contains("101")){
                c+=1;
            }
        }
        System.out.println(c);
    }
}
