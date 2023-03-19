package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Number16 {
    public static int maxNum;
    public static int time;
    public static boolean isReasonable(BoatSolve boatSolve, int maxNum) {
        boolean result = true;
        if (boatSolve.getSheep() + boatSolve.getWolf() + boatSolve.getFarmer() > maxNum) {
            result = false;
        }
        if (boatSolve.getFarmer() == 0 && boatSolve.getWolf() > boatSolve.getSheep()) {
            result = false;
        }
        if (boatSolve.getFarmer() == 0 && boatSolve.getWolf() == 0 && boatSolve.getSheep() == 0) {
            result = false;
        }
        return result;
    }

    public static BoatSolve gotRestBoatSolve(BoatSolve first, BoatSolve second) {
        BoatSolve boatSolve = new BoatSolve();
        boatSolve.setFarmer(first.getFarmer() - second.getFarmer());
        boatSolve.setSheep(first.getSheep() - second.getSheep());
        boatSolve.setWolf(first.getWolf() - second.getWolf());
        return boatSolve;
    }

    public static ArrayList<CountAnswer> gotCountAnswerList(CountAnswer countAnswer) {
        ArrayList<CountAnswer> countAnswerArrayList = new ArrayList<CountAnswer>();
        BoatSolve restBoatSolve = countAnswer.getRestBoat();
        ArrayList<BoatSolve> boatSolveArrayList = countAnswer.getBoatList();
        ArrayList<BoatSolve> answerList = getAnswerList(restBoatSolve);

        for (BoatSolve boatSolve : answerList) {
            BoatSolve newBoatSolve = gotRestBoatSolve(restBoatSolve, boatSolve);
            //todo 有可能全为0

            ArrayList<BoatSolve> tmpList = new ArrayList<BoatSolve>(boatSolveArrayList);
            tmpList.add(boatSolve);
            CountAnswer newCountAnswer = new CountAnswer();
            newCountAnswer.setBoatList(tmpList);
            newCountAnswer.setRestBoat(newBoatSolve);
            countAnswerArrayList.add(newCountAnswer);
        }
        return countAnswerArrayList;
    }

    public static boolean isOver(BoatSolve boatSolve) {
        boolean result = boatSolve.getSheep() == 0 && boatSolve.getWolf() == 0 && boatSolve.getFarmer() == 0;
        return result;
    }

    public static void repeatTask(CountAnswer countAnswer) {
        ArrayList<CountAnswer> list = gotCountAnswerList(countAnswer);
        for (CountAnswer answer : list) {
            if (isOver(answer.getRestBoat())) {
                if(time>answer.getBoatList().size()){
                    time = answer.getBoatList().size();
                }
            } else {
                repeatTask(answer);
            }
        }
    }



    public static ArrayList<BoatSolve> getAnswerList(BoatSolve restBoatSolve) {
        int maxSheep = maxNum;
        int maxWolf = maxNum;
        int maxFarmer = 1;
        if (restBoatSolve.getSheep() < maxNum) {
            maxSheep = restBoatSolve.getSheep();
        }
        if (restBoatSolve.getWolf() < maxNum) {
            maxWolf = restBoatSolve.getWolf();
        }
        if (restBoatSolve.getFarmer() == 0) {
            maxFarmer = 0;
        }
        ArrayList<BoatSolve> resultList = new ArrayList<BoatSolve>();
        int[] maxArr = {maxSheep, maxWolf, maxFarmer};
        int[] tmpArr = {0, 0, 0};
        boolean notEnd = true;
        while (notEnd) {
            BoatSolve boatSolve = new BoatSolve();
            boatSolve.setSheep(tmpArr[0]);
            boatSolve.setWolf(tmpArr[1]);
            boatSolve.setFarmer(tmpArr[2]);
            if (isReasonable(boatSolve, maxNum)) {
                resultList.add(boatSolve);
            }
            boolean flowOver = true;
            int index = 0;
            while (flowOver && index < 3) {
                int iT = tmpArr[index]+1;
                if (iT > maxArr[index]) {
                    tmpArr[index] = 0;
                    index++;
                } else {
                    tmpArr[index] = iT;
                    flowOver = false;
                }
            }
            notEnd = index < 3;
        }
        return resultList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        String[] strArr = numStr.split(" ");
        maxNum = Integer.parseInt(strArr[2]);
        int sheepNum = Integer.parseInt(strArr[0]);
        int wolfNum = Integer.parseInt(strArr[1]);
        BoatSolve boatSolve = new BoatSolve();
        boatSolve.setSheep(sheepNum);
        boatSolve.setWolf(wolfNum);
        boatSolve.setFarmer(1);
        time = sheepNum+wolfNum+1;
        CountAnswer countAnswer = new CountAnswer();
        countAnswer.setBoatList(new ArrayList<BoatSolve>());
        countAnswer.setRestBoat(boatSolve);
        repeatTask(countAnswer);
        System.out.println(time);
    }
}
