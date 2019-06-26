package gof.create.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();  //静态的
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;

    }
}
