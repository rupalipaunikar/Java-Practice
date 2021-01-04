public class Stack {

    private static final int MAX = 10;
    private int a[] = new int[MAX];
    private int top = -1;

    private void push(int i) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }

        a[++top] = i;
    }

    private void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        top--;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == MAX - 1;
    }

    private void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(a[i]);
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(10);
        stack.push(8);
        stack.push(5);
        stack.push(1);
        stack.push(10);
        stack.push(8);
        stack.push(5);
        stack.push(1);
        stack.push(10);

        //stack.print();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.print();
    }
}
