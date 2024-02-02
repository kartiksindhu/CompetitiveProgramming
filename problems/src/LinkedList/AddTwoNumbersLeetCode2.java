package LinkedList;

public class AddTwoNumbersLeetCode2 {
    static int carry = 0;

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode insert(ListNode list, int val) {
        ListNode newNode = new ListNode(val);
        if (list == null) {
            list = newNode;
        } else {
            ListNode node = list;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        return list;
    }

    private static void solve(ListNode l1, ListNode l2, ListNode result) {
        ListNode node = result;
        while (node.next != null) {
            node = node.next;
        }
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                node.next = new ListNode(1);
            }
        }
        if (l1 == null && l2 != null) {
            int add = l2.val + carry;
            result.next = new ListNode(add % 10);
            carry = add / 10;
            solve(null, l2.next, result.next);
        }
        if (l2 == null && l1 != null) {
            int add = l1.val + carry;
            result.next = new ListNode(add % 10);
            carry = add / 10;
            solve(l1.next, null, result.next);
        }
        if (l1 != null && l2 != null) {
            int add=  l1.val + l2.val + carry;
            result.next = new ListNode(add % 10);
            carry = add / 10;
            solve(l1.next, l2.next, result.next);
        }
    }

    private static void printList(ListNode list) {
        if (list != null) {
            System.out.print(list.val);
            printList(list.next);
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        insert(list1, 2);
        insert(list1, 4);
        insert(list1, 7);
        insert(list1, 1);
        insert(list1, 1);
        ListNode list2 = new ListNode();
        insert(list2, 5);
        insert(list2, 6);
        insert(list2, 4);
        ListNode result = new ListNode();
        solve(list1.next, list2.next, result);
        printList(result.next);
    }
}
