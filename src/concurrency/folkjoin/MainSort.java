package concurrency.folkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MainSort {
    private static Long[] getRandomLongNumber(int n){
        Random random = new Random();
        Long[] numbers = new Long[n];

        for(int i= 0; i < n; i++){
            Long num = random.nextLong();
            numbers[i] = num < 0 ? Math.abs(num) :num;
        }

        return numbers;
    }

    public static void main(String[] args){
        final int RUNTIMES = 10;
        final int SORTNUM = 10000000;
        final int QUICKSOFT_THRESHOLD = 36200;
        Long runTime;
        Long startTime;
        for(int i = 1; i < RUNTIMES +1; i++){
            System.out.println("The " + i + " run:");
            System.out.println("Generating " + SORTNUM + " numbers");
///???/????
            Long[] qsNumbers = Utils.getRandomLongNumber(SORTNUM);
            System.out.println("Excuting Quick Sort");
            startTime = System.currentTimeMillis();
            ////
            runTime = System.currentTimeMillis() - startTime;
            System.out.println("Total use: " + runTime);

            Long[] cqsNumbers = getRandomLongNumber(SORTNUM);
            System.out.println("Executing Concurrent Quick Sort");

            ForkJoinPool pool = new ForkJoinPool();
            ConcurrentQuickSort cqs = new ConcurrentQuickSort(QUICKSOFT_THRESHOLD, cqsNumbers);
            startTime = System.currentTimeMillis();
            pool.execute(cqs);
            while(!cqs.isDone()){}
         //   QuickSort.qsort(qsNumbers, 0, qsNumbers.length-1);
            runTime = System.currentTimeMillis() - startTime;

            //System.out.println("Total use: " + runTime);
            System.out.println("Total use: " + runTime);

        }
    }
}
