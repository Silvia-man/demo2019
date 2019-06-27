package gof.structure.bridge;

public interface StackImpl {
    void push(int i);
    int pop();
    int top();
    boolean isEmpty();
    boolean isFull();
}
