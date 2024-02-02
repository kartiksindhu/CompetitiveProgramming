package LinkedList;

import java.util.List;

public class RotateListLeetCode61 {

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

    public static void insert(ListNode list, int val) {
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
    }

    private static void printList(ListNode list) {
        if (list != null) {
            System.out.print(list.val);
            printList(list.next);
        } else {
            System.out.println();
        }
    }

    //recurrsion
    /*public static ListNode solve(ListNode head, int k) {
        printList(head);
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode lastNode = head;
        ListNode secondLastNode = null;
        while (lastNode.next != null) {
            if (lastNode.next.next == null) {
                secondLastNode = lastNode;
            }
            lastNode = lastNode.next;
        }
        lastNode.next = firstNode;
        secondLastNode.next = null;
        return solve(lastNode, k - 1);
    }*/

    public static ListNode solve(ListNode head, int k, int length) {
        length = length - k - 1;
        ListNode firstNode = head;
        while (length > 0) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        insert(listNode, 1);
        insert(listNode, 2);
        insert(listNode, 3);
        ListNode tempList = listNode.next;
        int length = 0;
        while (tempList != null) {
            length++;
            tempList = tempList.next;
        }
        System.out.println(length);
        System.out.println(2000000000 % length);
        ListNode result = solve(listNode.next, 2000000000 % length, length);
        System.out.println("-------------------------");
        printList(result);
    }
}
