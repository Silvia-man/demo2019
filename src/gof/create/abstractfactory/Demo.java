package gof.create.abstractfactory;

public class Demo {
    public static void main(String[] args) {

        AbstractFactory coreFactory = AbstractFactory.getInstance(Architecture.CORE);
        CPU cpu = coreFactory.creatCPU();
        System.out.println(cpu);

        AbstractFactory xeonFactory = AbstractFactory.getInstance(Architecture.CORE);
        cpu = xeonFactory.creatCPU();
        System.out.println(cpu);
    }

}
