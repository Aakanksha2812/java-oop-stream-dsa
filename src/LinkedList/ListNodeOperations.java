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
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                tail.next = list1;

                list1 = list1.next;

            } else {

                tail.next = list2;

                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;

        }
        if (list2 != null) {
            tail.next = list2;

        }

        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            while (temp != null && temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lenA = 0;
        int lenB = 0;
        int pos = 0;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if (lenA > lenB) {
            pos = lenA - lenB;
            while (pos > 0) {
                pos--;
                p1 = p1.next;
            }
        } else {
            pos = lenB - lenA;
            while (pos > 0) {
                pos--;
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        //  l5.next = l2;
        l5.next = l6;
        ListNodeOperations op = new ListNodeOperations();
        // l1 = op.reverse(l1);
        //   l1 = op.middleNode(l1);
        // l1 = op.middleNodeSlowFastPointer(l1);
        //     System.out.println("Linked List Contain cycle: " + op.hasCycle(l1));
        //   System.out.println("cycle detected at : " + op.detectCycle(l1).val);
        //  l1 = op.mergeTwoLists(l1, l4);

        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(1);
        //  ListNode l10 = new ListNode(9);
        l7.next = l8;
        l8.next = l9;
        //  l9.next=l10;
        l7 = op.deleteDuplicates(l7);
        l7.printLL();
    }
}
