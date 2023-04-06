package lessonPractice;

public class SortMethod {
    /**
     * 选择排序法
     * @param arr 数组
     */
    public static void chooseSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序法
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序法
     * @param arr 数组
     */
    public static void insertMethod(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int temp = arr[i];
            for (;j>=0&&temp<arr[j];j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,6,2,1,8,9};
        insertMethod(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
