package LinkedList;

public class MergeTwoSortedListsLeetCode21 {
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
    private void solve(ListNode list1, ListNode list2, ListNode finalList) {
        ListNode node = finalList;
        while (node.next != null) {
            node = node.next;
        }
        if (list1 != null && list2 != null) {
            System.out.println("list1 " + list1.val);
            System.out.println("list2 " + list2.val);
            System.out.println(node.val);
            System.out.println();
            if (list1.val < list2.val) {
                node.next = new ListNode(list1.val);
                solve(list1.next, list2, finalList);
            } else {
                node.next = new ListNode(list2.val);
                solve(list1, list2.next, finalList);
            }
        } else {
            if (list1 == null && list2 != null) {
                node.next = new ListNode(list2.val);
                solve(null, list2.next, finalList);
            }
            if (list2 == null && list1 != null) {
                node.next = new ListNode(list1.val);
                solve(list1.next, null, finalList);
            }
        }
    }
    public static void main(String[] args) {
        MergeTwoSortedListsLeetCode21 merge = new MergeTwoSortedListsLeetCode21();
        ListNode list1 = new ListNode();
        insert(list1, 1);
        insert(list1, 2);
        insert(list1, 4);
        ListNode list2 = new ListNode();
        insert(list2, 1);
        insert(list2, 3);
        insert(list2, 4);
        insert(list2, 5);
        insert(list2, 7);
//        printList(list1);
//        printList(list2);
        ListNode result = new ListNode();
        printList(result);
        merge.solve(list1, list2, result);
        printList(result);
    }
}
