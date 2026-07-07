package LinkedList;



public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    void printLL() {
        ListNode temp = this;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /* ListNode insertAtBeginning(ListNode head, ListNode newNode){
         newNode.next=head;
         head=newNode;
         return head;
     }*/
    ListNode insertAtBeginning(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;

        head = newNode;
        return head;
    }

    ListNode insertAtEnd(ListNode head, int val) {
        ListNode newNode = new ListNode(val);


        if (head == null) {
            return newNode;
        }

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    ListNode insertAtPosition(ListNode head, int val, int position) {

        ListNode newNode = new ListNode(val);


        if (head == null) {
            if (position == 0) {
                return newNode;
            }
            return null;
        }


        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        ListNode temp = head;
        int count = 0;


        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }


        if (temp == null) {
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    ListNode deleteAtBeginning(ListNode head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    ListNode deleteAtEnd(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

    ListNode deleteAtPosition(ListNode head, int pos) {
        if (head == null) {
            return null;
        }
        if (pos == 0) {
            return head.next;
        }
        int count = 0;
        ListNode temp = head;

        while (temp != null && count < pos - 1) {

            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l1 = l1.insertAtBeginning(l1, 6);
        l1 = l1.insertAtEnd(l1, 7);
        l1 = l1.insertAtPosition(l1, 8, 2);
        l1 = l1.insertAtPosition(l1, 9, 0);
        l1 = l1.insertAtPosition(l1, 10, 10);
        l1 = l1.deleteAtBeginning(l1);
        l1 = l1.deleteAtEnd(l1);
        l1 = l1.deleteAtPosition(l1, 2);
        l1.printLL();

    }
}
