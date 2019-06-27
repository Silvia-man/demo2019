package gof.structure.adapter;

public interface SocketAdapter {
    int TWO = 2;
    int TEN = 10;
    int STANDARD = 220;

    Volt get2Volt();
    Volt get10Volt();
    Volt get220Volt();

}
