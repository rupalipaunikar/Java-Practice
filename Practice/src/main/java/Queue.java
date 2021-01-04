public class Queue {

    private static final int MAX = 10;
    private int a[] = new int[MAX];
    private int front = -1;
    private int rear = -1;

    private void enqueue(int i) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else if (isEmpty()) {
            rear = front = 0;
        } else {
            rear = (rear + 1) % MAX;
        }
        a[rear] = i;
    }

    private void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX;
        }
    }

    private boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    private boolean isFull() {
        return (rear + 1) % MAX == front;
    }

    private int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return a[front];
    }

    private void print() {
        for (int i = front; i <= rear; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(9);
        queue.enqueue(33);
        queue.enqueue(44);
        queue.enqueue(55);
        queue.enqueue(66);
        queue.enqueue(79);
        queue.enqueue(89);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.print();
        System.out.println("FRONT === " + queue.front());
    }
}
