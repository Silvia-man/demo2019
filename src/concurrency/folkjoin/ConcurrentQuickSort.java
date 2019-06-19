package concurrency.folkjoin;

import java.util.concurrent.RecursiveAction;

public class ConcurrentQuickSort extends RecursiveAction {
    private int threshold = 30;
    private int low;
    private int high;
    private Long[] numbers;

    public ConcurrentQuickSort(int threshold, Long[] numbers) {
        this.numbers = numbers;
        this.low = 0;
        this.high = numbers.length - 1;
        this.threshold = threshold;
    }

    public ConcurrentQuickSort(Long[] numbers, int low, int high ){
        this.low = low;
        this.high = high;
        this.numbers = numbers;
    }

    private static int partition(Long[] numbers, int low, int high){
        Long soldier = numbers[low];
        while(low < high){
            while(low < high){
                if(numbers[high] < soldier) {
                    numbers[low] = numbers[high];
                    break;
                }

                high--;
            }
            while(low < high){
                if (numbers[low] > soldier){
                    numbers[high] = numbers[low];


                }
                low++;
            }
        }
        numbers[low] = soldier;
        return low;
    }


    @Override
    protected void compute() {
        if(high - low < threshold) {
            QuickSort.qsort(numbers, low, high);
        } else{
            int soldier = partition(numbers, low, high);
            ConcurrentQuickSort left = new ConcurrentQuickSort(numbers, low, soldier -1);
            ConcurrentQuickSort right = new ConcurrentQuickSort(numbers, soldier + 1, high);
            invokeAll(left, right);
        }
    }
}
