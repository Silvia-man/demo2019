package gof.create.factory;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type)){
            return new PC(ram, hdd, cpu);
        } else if("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        }

        return null;
    }


    public static void main(String[] args) {
        Computer computer = ComputerFactory.getComputer("pc", "2GB", "500GB", "Core i7");
        System.out.println(computer);
        Computer server = ComputerFactory.getComputer("server", "100GB", "500T", "Xeon E");
        System.out.println(server);
    }
}
