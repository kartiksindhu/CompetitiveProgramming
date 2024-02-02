package LinkedList;

import java.util.List;

public class SwapNodesInPairsLeetCode24 {
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
        ListNode result = listNode;
        ListNode previous = listNode;
        ListNode current = listNode.next;
        while (current != null && current.next != null) {
            ListNode nextPair = current.next.next;

            ListNode firstNode = current;
            ListNode secondNode = current.next;

            //swapping of nodes
            previous.next = firstNode.next;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            previous = previous.next.next;

            current = nextPair;
        }
        return result.next;
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
        insert(listNode, 2);
        insert(listNode, 3);
        insert(listNode, 4);
        insert(listNode, 5);
        ListNode result = solve(listNode);
        printList(result);
    }
}
