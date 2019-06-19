package java8.lamda;

public class BasicLamda {
    private static void engine(Calculator calculate) {
        int x = 2, y = 4;
        int result = calculate.calculate(x, y);
        System.out.println(result);
    }

    private static Calculator divide(){           ////?????????
        return (x, y) -> y / x;
    }
    public static void main(String[] args) {

        engine((x, y) -> x + y);
        engine((x, y) -> x * y);
        engine((x, y) -> x - y);

        engine(divide());

        Calculator c1 = divide();
        System.out.println(c1.calculate(2, 10));
    }
}
