package algorithm_theory.Sort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        //case1 : left/right 둘다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        //case2 : right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }
        //case3 : left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int) (Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        System.out.println(mSort.mergeSplitFunc(testData));
    }
}
