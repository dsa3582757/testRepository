package passExam;

import java.util.Scanner;
import java.util.Stack;

public class TestDemo11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int num = scanner.nextInt();
        while (num>0){
            stack.add(num%2);
            num = num/2;
        }
        int score = 0;
        for (Integer integer : stack) {
            if(integer==1){
                score++;
            }
        }
        System.out.println(score);
    }
}
