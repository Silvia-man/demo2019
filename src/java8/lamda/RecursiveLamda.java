package java8.lamda;

import java.util.function.IntFunction;

public class RecursiveLamda {
    public static void main(String[] args) {
        IntFunction<Long> facCalc = RecursiveLamda::factorial;
        System.out.println(facCalc.apply(5));
    }

    private static long factorial(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }




}
