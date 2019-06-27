package gof.structure.adapter;

public class DemoAdapter {
    public static void main(String[] args) {
        SocketAdapter socketAdapter = new SocketAdapterImpl();

        Volt v2 = getVolt(socketAdapter, SocketAdapter.TWO);
        System.out.println("v2 volts using adapter = " + v2.getVolts());

        Volt v10 = getVolt(socketAdapter, SocketAdapter.TEN);
        System.out.println("v10 volts using adapter = " + v10.getVolts());

        Volt v220 = getVolt(socketAdapter, SocketAdapter.STANDARD);
        System.out.println("v220 volts using adapter = " + v220.getVolts());
    }

    private static Volt getVolt(SocketAdapter socketAdapter, int i) {

        switch (i) {
            case SocketAdapter.TWO:
                return socketAdapter.get2Volt();

            case SocketAdapter.TEN:
                return socketAdapter.get10Volt();

            default:
                return socketAdapter.get220Volt();
        }
    }


}
