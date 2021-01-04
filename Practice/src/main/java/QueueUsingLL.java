public class QueueUsingLL {

    Node front;
    Node rear;

    private void enqueue(int i) {
        Node node = new Node(i);

        if(isEmpty()){
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    private void dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
    }

    private boolean isEmpty() {
        return front == null && rear == null;
    }

    private int front() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    private void print() {
        Node temp = front;
        while (temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();

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
        queue.dequeue();

        queue.print();
        System.out.println("FRONT === " + queue.front());
    }
}
