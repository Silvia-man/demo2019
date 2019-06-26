package gof.create.abstractfactory;

public class CoreFactory extends AbstractFactory {

    @Override
    public CPU creatCPU() {
        return new CoreCPU();
    }

    @Override
    public MMU creatMMU() {
        return new CoreMMU();
    }

}
