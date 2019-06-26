package gof.create.abstractfactory;

public class XeonFactory extends AbstractFactory{
    @Override
    public CPU creatCPU() {
        return new XeonCPU();
    }

    @Override
    public MMU creatMMU() {
        return new XeonMMU();
    }
}
