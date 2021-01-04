public class StackUsingLL {

    private Node head;

    private void push(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    private void pop() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
    }

    private void display(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.data);
        display(head.next);
    }

    private Integer peek() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        } else {
            return head.data;
        }
    }

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        stack.push(2);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(0);


        stack.display(stack.head);
        System.out.println("PEEK --- "+stack.peek());

        stack.pop();
        stack.pop();

        stack.display(stack.head);
        System.out.println("PEEK --- "+stack.peek());
    }
}
