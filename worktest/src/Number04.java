import java.util.Scanner;
//一个图像有n个像素点，存储在一个长度为n的数组img里，每个像素点的取值范围[0,255]的正整数。
//        请你给图像每个像素点值加上一个正整数k（可以是负数）得到新图newlmg的所有像素平均值最接近中位值128。
//        请输出这个整数k。
//        输入描述:
//        N个整数，中间用空格分开  例如： 0 0 0 0
//        输出描述:
//        一个整数 k
//        示例:
//        输入 129 130 129 130
//        输出 -2
//        说明: -1的均值 128.5 , -2的均值127.5，输出较小的-2
public class Number04 {
    public static class Inf {
        public int id;
        public int sum;
    }
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = 4;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Inf minInf = new Inf();
        minInf.sum = (255+128)*4;
        for (int i = -255; i <=255 ; i++) {
            Inf inf = new Inf();
            inf.id = i;
            int tmp = 0;
            for (int i1 : arr) {
                tmp =tmp + i1+ i;
            }
            inf.sum = tmp-128*4;
            if(inf.sum>=0 && inf.sum<minInf.sum){
                minInf.sum = inf.sum;
                minInf.id = inf.id;
            } else if (inf.sum<0 && inf.sum*(-1)<=minInf.sum) {
                minInf.sum = (-1)* inf.sum;
                minInf.id = inf.id;
            }
        }
        System.out.println(minInf.id);
    }
}
