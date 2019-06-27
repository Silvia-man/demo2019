package gof.structure.bridge;

public class StackLink implements StackImpl{
    private Node current;

    @Override
    public void push(int i) {
        if (current == null) {
            current = new Node(i);
        } else {
            current.next = new Node(i);
            current.next.prev = current;
            current = current.next;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int value = current.value;
        current = current.prev;
        return value;
    }

    @Override
    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return current.value;
    }

    @Override
    public boolean isEmpty() {
        return current == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
