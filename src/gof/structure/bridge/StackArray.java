package gof.structure.bridge;

public class StackArray implements StackImpl{
    private int[] items;
    private int total = -1;

    public StackArray() {
        this.items = new int[12];
    }

    @Override
    public void push(int i) {
        if(!isFull()) {
            items[++total] = i;
        }

    }

    @Override
    public int pop() {
        return isEmpty() ? -1 : items[total--];
    }

    @Override
    public int top() {
        return isEmpty() ? -1 : items[total];
    }

    @Override
    public boolean isEmpty() {
        return total == -1;
    }

    @Override
    public boolean isFull() {
        return total == items.length -1;
    }
}
