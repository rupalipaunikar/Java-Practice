class DoubleNode {
    int data;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {

    DoubleNode head;

    private void insertAtHead(int data) {
        DoubleNode node = new DoubleNode(data);

        if(head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void insertAtTail(int data) {
        DoubleNode node = new DoubleNode(data);

        if(head == null) {
            head = node;
        } else {
            DoubleNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    private void print() {
        DoubleNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private void reversePrint() {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while(temp !=null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertAtHead(22);
        linkedList.insertAtHead(42);
        linkedList.insertAtHead(29);
        linkedList.insertAtTail(33);

        linkedList.print();

        System.out.println("Reverse ---");
        linkedList.reversePrint();
    }
}
