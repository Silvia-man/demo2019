package java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CreatBuilder {

    static int i = 0;
    private int next() {
        i++;
        return i;
    }
    public static void main(String[] args) {
        Stream<String> stream = Stream.<String>builder().add("Web").add("Java").add("Spring")
                .add("Cloud").add("Docker").build();
        stream.forEach(System.out::println);


        String str = "5 2 88 12 abc,12, 8,1 25";
        str.chars().filter(n -> !Character.isDigit(n) || !Character.isWhitespace(n))
                .forEach(n -> System.out.print((char)n));

        Stream<String> classes = Arrays.stream(new String[] {"Java", "Damo", "Diaoyutai", "2019"});
        classes.forEach(System.out::println);// 方法引用

        Set<String> names = new HashSet<>();
        names.add("Java");
        names.add("Dharma");
        names.add("Diaoyutai");
        names.add("2019");

        Stream<String> parallelStream = names.parallelStream();
        parallelStream.forEach(System.out::println);



        Stream.generate(() -> ++i);

    }
}
