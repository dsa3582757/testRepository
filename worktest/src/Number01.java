public class Number01 {
//    题1：
//    任务编排服务负责对任务进行组合调度。参与编排的任务有两种类型，其中一种执行时长为taskA,另一种执行时长为taskB。任务一旦开始执行不能打断，且任务可连续执行。服务每次可编排num个任务。请编写一个方法，
//    生成每次编排后的任务所有可能的总执行时长。
//    输入描述:第1行输入分别为第1种任务执行时长taskA,第2种任务执行时长taskB,这次要编排的任务个数num，以逗号分隔。
//    输出描述:数组形式返回所有总执行时长，需要按从小到大排序
//    示例:
//    输入  1,2,3
//    输出  [3,4,5,6]
//    说明:可以执行3次taskA,得到结果3，执行2次taskA和1次taskB,得到结果4,以此类推，得到最终结果
//    备注:每次任务的数量都大于本次可以编排的任务数量
//0<taskA
//0<taskB
//0<=num <= 100000
    public static void main (String[]args) {
        int tastA = 1;
        int tastB = 2;
        int num = 3;
        int[] sum = new int[num + 1];
        int sumA;
        int sumB;
        for (int i = 0; i <= num; i++) {
            sumA = tastA * (num - i);
            sumB = tastB * i;
            int sumTmp = sumA + sumB;
            sum[i] = sumTmp;
        }
        for (int i : sum) {
            System.out.println(i);
        }
    }
}
