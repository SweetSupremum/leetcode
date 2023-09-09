package easy;

/**
 * {@see https://leetcode.com/problems/merge-two-sorted-lists}
 *
 * @author SweetSupremum
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        new MergeTwoSortedLists().mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
        );
    }

    //1-2-4
    //1-3-4
    //null, 0
    // null, null
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                listNode.val = list2.val;
                if (list2.next != null) {
                    listNode.next = new ListNode();
                    listNode = listNode.next;
                }
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                listNode.val = list1.val;
                if (list1.next != null) {
                    listNode.next = new ListNode();
                    listNode = listNode.next;
                }
                list1 = list1.next;
                continue;
            }
            if (list1.val < list2.val) {
                listNode.val = list1.val;
                list1 = list1.next;
            } else {
                listNode.val = list2.val;
                list2 = list2.next;
            }

            listNode.next = new ListNode();
            listNode = listNode.next;
        }
        return temp;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
