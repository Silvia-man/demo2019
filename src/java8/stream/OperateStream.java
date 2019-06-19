package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OperateStream {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5).map(n -> n * n)
                .flatMap(n -> Stream.of(n, n+10))//.peek(n -> System.out.println("Filtered number: " + n))
                .forEach(System.out::print);   //流的嵌套


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(100/* 0 */, Integer::sum);//reduce()终端操作
        System.out.println(sum);




    }
}
