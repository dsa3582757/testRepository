package passExam;

import java.util.Scanner;

public class TestDemo14 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] coord = new int[]{0, 0};
        String[] strArr = str.split(";");
        for (String s : strArr) {
            if(isLegal(s)){
                char first = s.charAt(0);
                int temp = Integer.parseInt(s.substring(1));
                switch (first){
                    case 'A':
                        coord[0] = coord[0]-temp;
                        break;
                    case 'W':
                        coord[1] = coord[1] +temp;
                        break;
                    case 'S':
                        coord[1] = coord[1]-temp;
                        break;
                    case 'D':
                        coord[0] = coord[0] + temp;
                    default:
                        break;
                }
            }
        }
        System.out.println(coord[0] + "," + coord[1]);
    }

    public static boolean isLegal(String str){
        String pattern = "[WASD][0-9]?[0-9]";
        boolean legal = str.matches(pattern);
        return legal;
    }
}
