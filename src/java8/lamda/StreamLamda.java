package java8.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StreamLamda {
      private static boolean isPrime(int number) {
//        if(number < 2) {
//            return false;
//        }
//
//        for(int i = 2; i < number; i++) {
//            if(number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
          IntPredicate isDivisible = i -> number % i != 0;
          return number > 1 && IntStream.range(2, number).allMatch(isDivisible);
      }


      private static int 条件求和(List<Integer> numbers, Predicate<Integer> predicate) {
          return numbers.parallelStream().filter(predicate).mapToInt(i -> i).sum();
      }


      private static int squareOfMaxOdd(List<Integer> numbers) {
          return numbers.stream().filter(i -> i%2 != 0).filter(i -> i>3  && i<11)
                  .max(Comparator.naturalOrder()).map(i -> i * i).get();////////?????????
      }

      public static void main(String[] args) {
          System.out.println(isPrime(7));
          System.out.println(isPrime(188));

          List<Integer> numbers = Arrays.asList(10, 9, 4, 8 , 1, 1, 2, 8, 13);

          System.out.println(条件求和(numbers, i -> i > 5));
          System.out.println(squareOfMaxOdd(numbers));
      }
}


