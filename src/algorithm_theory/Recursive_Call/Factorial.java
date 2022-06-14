package algorithm_theory.Recursive_Call;

import java.util.ArrayList;

public class Factorial {

    public int factorialFunc_multiple(int num) {
        if (num == 1) {         //재귀호출을 종료하기 위한 조건 작성
                return 1;  // 일반적인 로직상, 리턴값은 1로 작성해도 됨
        }
        return num * this.factorialFunc_multiple(num - 1);
    }

    public int factorialFunc_sum(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + this.factorialFunc_sum(new ArrayList<>(dataList.subList(1, dataList.size())));
    }

    public static void main(String[] args) {
        Factorial fObject = new Factorial();
        ArrayList<Integer> testdata = new ArrayList();
        for (int data = 0; data < 10; data++) {
            testdata.add(data);
        }

        System.out.println(fObject.factorialFunc_multiple(5));
        System.out.println(fObject.factorialFunc_sum(testdata));
    }
}
