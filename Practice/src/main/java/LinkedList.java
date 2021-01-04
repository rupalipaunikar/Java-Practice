import java.util.Stack;

public class LinkedList {

    private Node head;

    private void insertAtTheEnd(int data) {
        /* Create new node */
        Node node = new Node(data);

        /* Insert as a first element as head is null */
        if (head == null) {
            head = node;
        } else {
            /* Insert at the last */
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private void insertAtTheBeginning(int data) {
        /* Create new node */
        Node node = new Node(data);

        /* Insert as a first element as head is null. */
        if (head == null) {
            head = node;
        } else {
            /* Insert at the beginning */
            node.next = head;
            head = node;
        }
    }

    private void insertAtNthPosition(int data, int position) {
        /* Create new node */
        Node node = new Node(data);

        /* Insert as a first element as head is null. */
        if (head == null) {
            head = node;
        } else if (position == 0) {
            insertAtTheBeginning(data);
        } else if (position == length()) {
            insertAtTheEnd(data);
        } else if (position > length()) {
            throw new RuntimeException("Position specified is greater than the length.");
        } else {
            /* Starting position same for both current and previous nodes */
            Node current = head;
            Node previous = current;

            int i = 1;
            while (i < position) {
                /* Previous will always be one node behind current during iteration */
                previous = current;
                current = current.next;
                i++;
            }
            /* Adjust links ===  PREVIOUS --> NODE --> CURRENT */
            node.next = current;
            previous.next = node;
        }
    }

    private void remove(int position) {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
        } else if (position > length()) {
            System.out.println("Cannot remove element");
        } else if (position == 0) {
            Node temp = head;
            temp = temp.next;
            head = temp;
        } else {
            /* Starting position same for both current and previous nodes */
            Node current = head;
            Node previous = current;
            int i = 1;

            while (i < position) {
                /* Previous will always be one node behind current during iteration
                *  Current node should point to the node which is to be removed */
                previous = current;
                current = current.next;
                i++;
            }
            previous.next = current.next;
            current.next = null;
        }
    }

    private void reverseUsingIteration() {
        Node current = head;
        Node prev = null, next;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private void reverseUsingRecursion(Node p) {
        if(p.next == null) {
            head = p;
            return;
        }

        reverseUsingRecursion(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    private int length() {
        int length = 0;
        if (head == null) {
            System.out.println("List is empty");
        }

        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    private void display(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.data);
        display(head.next);
    }

    private void reverseDisplay(Node head) {
        if (head == null) {
            return;
        }
        reverseDisplay(head.next);
        System.out.println(head.data);
    }

    private void reverseUsingStack() {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        temp = stack.pop();
        head = temp;
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtTheEnd(3);
        linkedList.insertAtTheEnd(7);
        linkedList.insertAtTheEnd(10);
        linkedList.insertAtTheEnd(255);
        linkedList.insertAtTheEnd(678);
        linkedList.insertAtTheEnd(1000);
        //linkedList.remove(0);

        linkedList.display(linkedList.head);
        //linkedList.reverseUsingIteration();
        //linkedList.display(linkedList.head);
        //linkedList.reverseDisplay(linkedList.head);
//        linkedList.reverseUsingRecursion(linkedList.head);
//        linkedList.display(linkedList.head);
//        System.out.println("Length:- " + linkedList.length());

        linkedList.reverseUsingStack();
        linkedList.display(linkedList.head);
    }
}
