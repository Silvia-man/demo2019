package concurrency.folkjoin;

public class QuickSort {
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


public static void qsort(Long[] numbers, int low, int high){
    if(low < high) {
        int soilder = partition(numbers, low, high);
        qsort(numbers, low, soilder-1);
        qsort(numbers, soilder + 1, high);
    }
    }
}