package gof.create.abstractfactory;

public abstract class AbstractFactory {
    public abstract CPU creatCPU();
    public abstract MMU creatMMU();

    private static final CoreFactory CORE = new CoreFactory();
    private static final XeonFactory XEON = new XeonFactory();

    public static AbstractFactory getInstance(Architecture architecture){
        AbstractFactory factory = null;
        switch (architecture) {
            case CORE:
                factory = CORE;
                break;
            case XEON:
                factory = XEON;
                break;
        }

        return factory;
    }
}
