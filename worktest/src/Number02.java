import java.util.Scanner;

public class Number02 {
//    现在ng个容器服务，服务的启动可能有一定的依赖性(有些服务启动没有依赖)，其次服务自身启动加载会消耗一些时间。
//    给你一个nxn的二维矩阵userTime,，其中userTime[i][i]=10表示服务i自身启动加载需要10s, userTime[i][j] =1 表示服务i启动依赖服务j启动完成，userTime[i][k] = 0 ，表示服务i启动不依赖,服务k
//    其中 0<i,j,k<n。服务间启动没有循环依赖(不会出现环),若想对任意一个服务i进行集成测试(服务i 自身启动也需要加载)，求最少需要等待多长时间。
//    输入描述:
//    第一行输入服务总量n，之后的n行表示服务启动的依赖关系以及自身启动加载耗时
//    最后输入 k 表示计算需要等待多少时间后可以对服务k进行集成测试
//    其中 1<=k<=n, 1<=n<=100
    public int timeAdd(int k,int time,int size,int[][] arr){
        for (int i = 0; i <size ; i++) {
            if(arr[k][i]==10){
                time=time+10;
            } else if (arr[k][i]==0) {
                time=time +0;
            } else if (arr[k][i]==1) {
                time = time + timeAdd(i,0,size,arr);
            }
        }
        return time;
    }




    public static void main (String[]args){
        int size;
        int k;
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        int[][] arr = new int[size][size];
        for(int i=0;i<size;i++){
            for (int j = 0; j < size; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        k= scanner.nextInt()-1;
        int timeAll =0;
        timeAll = timeAll + new Number02().timeAdd(k,timeAll,size,arr);
        System.out.println(timeAll);
    }
}
