package java8.lamda;

import java.util.function.Function;

public class LamdaScope {
    private LamdaScope() {

//        Function<String, String> f1 = (x) -> {
//            System.out.println(this);       //lamda没有作用域，所以this指向了外部。放在栈里
//            return x;
//        };


        Function<String, String> f1 = new Function<String, String>() {
            @Override                          //这种匿名函数，就在内存中开辟了一块内存空间，有this。
            public String apply(String s) {
                System.out.println(this);
                return s;
            }
        };


        System.out.println(f1.apply("Damo"));
    }


    @Override
    public String toString() {
        return "I am a dog.";
    }

    public static void main(String[] args) {
        new LamdaScope();

    }
}
