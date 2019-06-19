package java8.stream;

import java.util.Optional;

public class DemoOptional {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("MALE");
        System.out.println(gender);
        System.out.println(gender.get());
        System.out.println(Optional.empty()/* .get()*/.orElse("default"));

        System.out.println(Optional/*.of(null)*/.ofNullable(null));
    }
}
