package algorithm_theory.DP;

public class Dynamic {
    public int factorial(int n) {  //recursive call로 피보나치 구현
        if (n <= 1) {
            return n;
        }
        return factorial(n - 1) + factorial(n - 2);
    }

    public int dynamicFunc(int data) { //dynamic programming으로 피보나치 구현
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < data + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[data];
    }


    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();
        System.out.println(dynamic.factorial(9));
        System.out.println(dynamic.dynamicFunc(9));
    }
}
