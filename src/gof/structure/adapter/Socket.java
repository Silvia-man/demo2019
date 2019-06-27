package gof.structure.adapter;

public class Socket {
    Volt getVolt() {
        return new Volt(220);
    }
}
