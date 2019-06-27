package gof.structure.bridge;

public class StackHanoi extends Stack {
    private int totalRejected = 0;

    public StackHanoi() {
        super("array");
    }

    public StackHanoi(String type) {
        super(type);
    }

    public int reportRejected() {
        return totalRejected;
    }

    @Override
    public void push(int in) {
        if(!isEmpty() && in > top()) {
            totalRejected++;
        } else {
            super.push(in);
        }
    }
}
