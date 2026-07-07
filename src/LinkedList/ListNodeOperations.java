package LinkedList;

public class ListNodeOperations {
    ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count / 2;
        count = 0;
        temp = head;

        while (temp != null && count < mid) {

            count++;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode middleNodeSlowFastPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr=head;
                while (ptr != slow) {
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        //  ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l2;
        //  l5.next=l6;
        ListNodeOperations op = new ListNodeOperations();
        // l1 = op.reverse(l1);
        //   l1 = op.middleNode(l1);
        // l1 = op.middleNodeSlowFastPointer(l1);
        System.out.println("Linked List Contain cycle: " + op.hasCycle(l1));
        System.out.println("cycle detected at : " + op.detectCycle(l1).val);
        //  l1.printLL();
    }
}
