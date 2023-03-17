import java.util.ArrayList;
import java.util.Scanner;

//题14-租车骑绿道
//        部门组织绿道骑行团建活动。租用公共双人自行车骑行，每辆自行车最多坐两人、最大载重M。
//        给出部门每个人的体重，请问最多需要租用多少双人自行车。
//        输入描述：
//        第一行两个数字m、n，自行车限重m，代表部门总人数n
//        第二行，n个数字，代表每个人的体重。体重都小于等于自行车限重m
//        0<m<=200
//        0<=n=1000000
//        输出描述：
//        最小需要的双人自行车数量
//        示例：
//        输入
//        3 4
//        3 2 2 1
//        输出：
//        3

public class Number14 {
    public static int maxWeightNum;
    public static int bikeNum;
    public static ArrayList getSubList(ArrayList list, int max) {
        ArrayList result = new ArrayList();
        if (list.size() == 1 && Integer.parseInt(list.get(0).toString()) <= max) {
            ArrayList tmp = new ArrayList();
            tmp.add(list.get(0));
            result.add(tmp);
            return result;
        } else {
            //取一个的情况
            for (int i = 0; i < list.size(); i++) {
                ArrayList tmp = new ArrayList();
                if (Integer.parseInt(list.get(i).toString()) <= max) {
                    tmp.add(list.get(i));
                    if(result.size()>0){
                        boolean contain = false;
                        for (int j = 0; j < result.size(); j++) {
                            if(isSame(tmp,(ArrayList) result.get(j))){
                                contain = true;
                                break;
                            }
                        }
                        if(!contain){
                            result.add(tmp);
                        }
                    }
                    else {
                        result.add(tmp);
                    }
                }
            }
            //取两个的情况
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    ArrayList tmp = new ArrayList<>();
                    if (Integer.parseInt(list.get(i).toString()) + Integer.parseInt(list.get(j).toString()) <= max) {
                        tmp.add(list.get(i));
                        tmp.add(list.get(j));
                        boolean contain = false;
                        for (int k = 0; k <result.size() ; k++) {
                            if(isSame(tmp,(ArrayList) result.get(k))){
                                contain = true;
                                break;
                            }
                        }
                        if(!contain){
                            result.add(tmp);
                        }
                    }
                }
            }
        }
        return result;
    }
    public static ArrayList<TmpAnswer> gotTmpAnswerList(TmpAnswer tmpAnswer){
        ArrayList list = new ArrayList();
        list = tmpAnswer.getRestList();
        ArrayList answerList = new ArrayList();
        answerList = getSubList(list,maxWeightNum);
        ArrayList<TmpAnswer> tmpAnswerArrayList = new ArrayList<>();
        for (int i = 0; i < answerList.size(); i++) {
            TmpAnswer answer = new TmpAnswer();
            ArrayList tmp = (ArrayList) answerList.get(i);
            ArrayList newCountList = new ArrayList(tmpAnswer.getCountList());
            newCountList.add(tmp);
            answer.setCountList(newCountList);
            answer.setRestList(getRestList(list,tmp));
            tmpAnswerArrayList.add(answer);
        }
        return tmpAnswerArrayList;
    }
    public static void doTask(ArrayList list,int maxWeight){
        TmpAnswer tmpAnswer = new TmpAnswer();
        ArrayList<ArrayList> countList = new ArrayList<>();
        tmpAnswer.setRestList(list);
        tmpAnswer.setCountList(countList);
        repeatTask(tmpAnswer);
    }
    public static void repeatTask(TmpAnswer tmpAnswer){
        ArrayList<TmpAnswer> tmpAnswerArrayList = gotTmpAnswerList(tmpAnswer);
        for (int i = 0; i < tmpAnswerArrayList.size(); i++) {
            if(tmpAnswerArrayList.get(i).getRestList().size()==0){
                if(bikeNum>tmpAnswerArrayList.get(i).getCountList().size()){
                    bikeNum = tmpAnswerArrayList.get(i).getCountList().size();
                }
            } else {
                repeatTask(tmpAnswerArrayList.get(i));
            }
        }
    }

    //仅限包含两个数字的list的排序比较
    public static boolean isSame(ArrayList listA,ArrayList listB){
        boolean same = false;
        if(listA.size()!= listB.size()){
            same = false;
        } else if (listA.size()==1) {
            int tmpA = Integer.parseInt(listA.get(0).toString());
            int tmpB = Integer.parseInt(listB.get(0).toString());
            if(tmpB==tmpA){
                same = true;
            }
        } else {
            int tmpA_0 = Integer.parseInt(listA.get(0).toString());
            int tmpA_1 = Integer.parseInt(listA.get(1).toString());
            int tmpB_0 = Integer.parseInt(listB.get(0).toString());
            int tmpB_1 = Integer.parseInt(listB.get(1).toString());
            if((tmpA_0==tmpB_0&&tmpA_1==tmpB_1)||(tmpA_0==tmpB_1&&tmpA_1==tmpB_0)){
                same = true;
            }
        }
        return same;
    }

    public static ArrayList getRestList(ArrayList list, ArrayList countList) {
        ArrayList resultList = new ArrayList(list);
        for (int i = 0; i < countList.size(); i++) {
            for (int j = 0; j < resultList.size(); j++) {
                //todo
                if (Integer.parseInt(resultList.get(j).toString()) == Integer.parseInt(countList.get(i).toString())) {
                    resultList.remove(j);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weight_peopleNum = scanner.nextLine();
        String peopleWeight = scanner.nextLine();
        maxWeightNum = Integer.parseInt(weight_peopleNum.split(" ")[0]);
        int peopleNum = Integer.parseInt(weight_peopleNum.split(" ")[1]);
        bikeNum = peopleNum;
        String[] peopleWeightStrArr = peopleWeight.split(" ");
        int[] peopleWeightNumArr = new int[peopleWeightStrArr.length];
        ArrayList list = new ArrayList();
        for (int i = 0; i < peopleWeightNumArr.length; i++) {
            peopleWeightNumArr[i] = Integer.parseInt(peopleWeightStrArr[i]);
            list.add(peopleWeightNumArr[i]);
        }
        doTask(list,maxWeightNum);
        System.out.println(bikeNum);
    }
}
