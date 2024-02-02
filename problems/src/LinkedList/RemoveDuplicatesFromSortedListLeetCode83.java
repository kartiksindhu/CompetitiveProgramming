package LinkedList;

import java.util.List;

public class RemoveDuplicatesFromSortedListLeetCode83 {

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

    private static ListNode solve(ListNode listNode) {
        return null;
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
        ListNode listNode = new ListNode();
        insert(listNode, 1);
        insert(listNode, 1);
        insert(listNode, 2);
        insert(listNode, 2);
        insert(listNode, 2);
        insert(listNode, 3);
        insert(listNode, 3);
        ListNode result = solve(listNode.next);
        printList(result);
    }
}
