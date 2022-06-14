package algorithm_theory.Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        //정렬이 되지 않은 ArrayList<Integer> dataList를 인자로 받아 정렬한 dataList를 반환하는 ArrayList<Integer> 타입의 sort 메소드를 정의한 것이다.
        for (int index = 0; index < dataList.size() - 1; index++) {
            boolean swap = false;

            for (int index2 = 0; index2 < dataList.size() - 1 - index; index2++) {
                if (dataList.get(index2) > dataList.get(index2 + 1)) {
                    Collections.swap(dataList, index2, index2 + 1);
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        BubbleSort bSort = new BubbleSort();
        bSort.sort(testData);
        System.out.println(testData);
    }
}
