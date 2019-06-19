package java8.lamda;
@FunctionalInterface
interface IFormula {
    double calculate(int a);
    //double calculate2(int a);
    default double sqrt(int a){
        return Math.sqrt(positive(a));
    }

    static int positive(int a) {
        return a > 0 ? a : 0;
    }

    default void log(Number result) {
        System.out.println(result);
    }
}
class Formula implements IFormula{

    @Override
    public double calculate(int a) {
        double result = sqrt((int)sqrt(a));
        log(result);
        return result;
    }

    @Override
    public void log(Number result){
        System.out.println("damo: " + result);
    }

}
public class DefaultMethod {
    public static void main(String[] args) {
        IFormula f1 = new Formula();
        f1.calculate(16);
        f1.calculate(-16);

        f1.log(1.888);
        f1.log(f1.sqrt(100));

        //lamda
        IFormula f2 = new IFormula() {
            @Override
            public double calculate(int a) {
                double result = sqrt((int)sqrt(a));
                log(result);
                return result;
            }
        };

        f2.calculate(256);
        f2.log(IFormula.positive(-20));

        IFormula f3 = (a) -> Math.sqrt(a*100);
        f3.log(f3.calculate(4));
    }


}
