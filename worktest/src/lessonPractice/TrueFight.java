package lessonPractice;

import java.util.regex.Pattern;

public class TrueFight {
    private static char cha ='a';

    public static void main(String[] args){
        int[] arr = {1,1,2,3,7,8,9,4,5,6,4};
        int index = 0;
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[i-1]+1){
                index++;
            }
            if(index>0&&arr[i]!=arr[i-1]+1){
                index = 0;
                sum++;
            }
        }
        System.out.println(sum);
    }
    //判断是否是数字
    public static boolean isNumberA(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    //判断是否是数字
    public static boolean isNumberB(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    //判断是否是数字
    public static boolean isNumberC(String str){
        for (int i = 0; i < str.length(); i++) {
            int chr = str.charAt(i);
            if(chr<48||chr>57){
                return false;
            }
        }
        return true;
    }

    public static boolean isReason(String str){
        boolean result = true;
        if(str.indexOf(cha)<0){
            result = false;
        }
        if(str.length()>1){
            for (int i = 1; i < str.length(); i++) {
                String tmp = str.substring(0,i);
                boolean contains = tmp.contains("" + str.charAt(i));
                if(contains){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static int getMax(String str){
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < str.length()-i+1; j++) {
                String tmp = str.substring(i,i+j);
                if(isReason(tmp)){
                    if(tmp.length()>max){
                        max = tmp.length();
                    }
                }
            }
        }
        return max ;
    }

    public static int getMinSite(){
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j =i+1; j < 10; j++) {

            }
        }


        return 1;
    }


}
