package exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Question03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int[] tmp = new int[2];
            String str = scanner.nextLine();
            tmp[0] = Integer.parseInt(str.split(",")[0]);
            tmp[1] = Integer.parseInt(str.split(",")[1]);
            list.add(tmp);
        }
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            integerHashSet = mergeSet(integerHashSet, list.get(i));
        }
        boolean notEnd = true;
        ArrayList<Integer> resultList = new ArrayList<>();
        HashSet<Integer> resultSet = new HashSet<>();
        int[] countArr = new int[list.size()];
        while (notEnd){
            resultSet = getHashSet(countArr,list);
            if(resultSet.size()==integerHashSet.size()){
                resultList.add(getNum(countArr));
            }
            int index = 0;
            boolean flowOver = true;
            while (flowOver&&index< list.size()){
                int iT = countArr[index]+1;
                if(iT>1){
                    countArr[index] = 0;
                    index++;
                } else {
                    countArr[index] = iT;
                    flowOver = false;
                }
            }
            notEnd = index<list.size();
        }
        System.out.println(getMin(resultList));
    }
    
    public static HashSet<Integer> getHashSet(int[] countArr,ArrayList<int[]> list){
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < countArr.length; i++) {
            if(countArr[i]==1){
                result = mergeSet(result,list.get(i));
            }
        }
        return result;
    }
    
    public static HashSet<Integer> merge(int[] a, int[] b){
        HashSet<Integer> result = new HashSet();
        for (int i = a[0]; i <=a[1] ; i++) {
            result.add(i);
        }
        for (int i = b[0]; i <=b[1]; i++) {
            result.add(i);
        }
        return result;
    }
    public static HashSet<Integer> mergeSet(HashSet<Integer> set,int[] ints){
        HashSet<Integer> result = new HashSet<>(set);
        for (int i = ints[0]; i <=ints[1]; i++) {
            result.add(i);
        }
        return result;
    }
    public static int getNum(int[] ints){
        int num = 0;
        for (int anInt : ints) {
            num+=anInt;
        }
        return num;
    }

    public static int getMin(ArrayList<Integer> list){
        int num = list.get(0);
        for (Integer integer : list) {
            if(num>integer){
                num = integer;
            }
        }
        return num;
    }
}
