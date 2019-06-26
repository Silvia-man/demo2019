package gof.create.singleton;

 class Eager {

    private static final Eager instance = new Eager();

    private Eager() {
    }

    public static Eager getInstance() {
        return instance;
    }

    private String paw = "Meat";

    public String getPaw() {
        return paw;
    }



}

public class EagerSingleton {
    public static void main(String[] args) {

        Eager eager = Eager.getInstance();
        System.out.println(eager.getPaw());
    }
}