package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * {@see https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150}
 *
 * @author SweetSupremum
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head != null) {
            if (listNodeSet.contains(head)) {
                return true;
            }
            listNodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
