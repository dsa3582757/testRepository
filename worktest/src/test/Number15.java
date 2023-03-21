package test;

import java.util.ArrayList;
import java.util.Scanner;
//题15 - 开心消消乐
//        给定一个N行M列的二维码，矩阵中每个位置的数字取值为0或1，矩阵示例如：
//        1 1 0 0
//        0 0 0 1
//        0 0 1 1
//        1 1 1 1
//        现需要将矩阵中所有的1 进行反转为0 ,规则如下：
//        1）当点击一个1时，该1变被反转为0 ，同时相邻的上，下，左，右，以及左上、左下、右上、右下8个方向的1(如果存在1) 均会自动反转为0
//        2）进一步地，一个位置上的1被反转为0时，与其相邻的8个方向的1(如果存在1)均会自动反转为0
//        按照上述规则示例中的矩阵只最少需要点击2次后，所有值为0，请问，给定一个矩阵，最少需要点击几次后，所有数字均为0？
//        输入描述：
//        输出一个整数，表示最少需要点击的次数
//        示例：
//        输入：
//        3 3
//        1 0 1
//        0 1 0
//        1 0 1
//        输入：
//        1
//        说明：
//        上述样例中，四个角的1均在中间的1的相邻的8个方向上，因此只需要点击1次即可
public class Number15 {
    public static int line;
    public static int column;
    public static int[][] matrix;
    public static int num=0;
    public static int[] getIntFromStr(String string){
        String[] strArr = string.split(" ");
        int[] resultArr = new int[strArr.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = Integer.parseInt(strArr[i]);
        }
        return resultArr;
    }

    public static ArrayList<Coord> getCoordList(Coord coord){
        ArrayList<Coord> list = new ArrayList<Coord>();
        int coordX = coord.getX();
        int coordY = coord.getY();
        Coord upLeft = new Coord();
        upLeft.setX(coordX - 1);
        upLeft.setY(coordY - 1);
        list.add(upLeft);
        Coord up = new Coord();
        up.setX(coordX);
        up.setY(coordY - 1);
        list.add(up);
        Coord upRight = new Coord();
        upRight.setX(coordX+1);
        upRight.setY(coordY-1);
        list.add(upRight);
        Coord left = new Coord();
        left.setX(coordX-1);
        left.setY(coordY);
        list.add(left);
        Coord right = new Coord();
        right.setX(coordX+1);
        right.setY(coordY);
        list.add(right);
        Coord downLeft = new Coord();
        downLeft.setX(coordX-1);
        downLeft.setY(coordY+1);
        list.add(downLeft);
        Coord down = new Coord();
        down.setX(coordX);
        down.setY(coordY+1);
        list.add(down);
        Coord downRight = new Coord();
        downRight.setX(coordX+1);
        downRight.setY(coordY+1);
        list.add(downRight);
        return list;
    }
    //判断时否有出界的
    public static boolean isOutside(ArrayList<Coord> list){
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            Coord tmpCoord = list.get(i);
            if(tmpCoord.getX()<0||tmpCoord.getX()>column||tmpCoord.getY()<0||tmpCoord.getY()>line){
                result = true;
            }
        }
        return result;
    }

    public static boolean isOver(int[][] matrix){
        boolean result = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==1){
                    result=false;
                    break;
                }
            }
        }
        return result;
    }

    public static void repeatTask(Coord coord){
        ArrayList<Coord> coordArrayList = new ArrayList<>();
        coordArrayList = getCoordList(coord);
        for (int i = 0; i < coordArrayList.size(); i++) {
            Coord tmpCoord = coordArrayList.get(i);
            if(tmpCoord.getX()>=0&&tmpCoord.getY()>=0&&tmpCoord.getX()<column&&tmpCoord.getY()<line){
                if(matrix[tmpCoord.getY()][tmpCoord.getX()]==1){
                    matrix[tmpCoord.getY()][tmpCoord.getX()]=0;
                    repeatTask(tmpCoord);
                }
            }
        }
    }
    public static void doTask(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==1){
                    Coord coord = new Coord();
                    coord.setX(j);
                    coord.setY(i);
                    matrix[i][j]=0;
                    repeatTask(coord);
                }
            }
        }
        num=num+1;
        if(!isOver(matrix)){
            doTask();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        line = Integer.parseInt(numStr.split(" ")[0]);
        column = Integer.parseInt(numStr.split(" ")[1]);
        matrix = new int[line][column];
        for (int i = 0; i < line; i++) {
            int[] perLine = new int[line];
            String tmpStr = scanner.nextLine();
            perLine = getIntFromStr(tmpStr);
            matrix[i] = perLine;
        }
        doTask();
        System.out.println(num);
    }
}


