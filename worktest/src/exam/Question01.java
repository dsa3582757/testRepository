package exam;

import java.util.Scanner;

public class Question01 {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String strChar = str.split(" ")[0];
        int wide = Integer.parseInt(str.split(" ")[1]);
        int size;
        if(strChar.length()%wide==0){
            size = strChar.length()/wide;
        }else {
            size = strChar.length()/wide+1;
        }
        char[] chars = strChar.toCharArray();
        for (int i = 0; i < size; i++) {
            char[] tmpChars = new char[size];
            for (int j = 0; j < wide; j++) {
                if(i*wide+j<strChar.length()){
                    if(i%2==1){
                        tmpChars[j] =chars[(i+1)*wide-j-1];
                    } else {
                        tmpChars[j] = chars[i*wide+j];
                    }
                }
            }
            String tmpStr = String.valueOf(tmpChars);
            System.out.println(tmpStr);
        }
    }
}
