package medium;

/**
 * {@see https://leetcode.com/problems/min-stack/}
 *
 * @author SweetSupremum
 */
public class MinStack {

    private ListNode current;
    private ListNode minNode;

    //хранить ссылки на минимальный элемент
    // 1-2-3-1
    // ссылки 1-1
    // при удалении
    public MinStack() {
        current = new ListNode();
        minNode = new ListNode(Integer.MAX_VALUE);
    }

    public void push(int val) {
        if (val <= minNode.val) {
            ListNode minNodeNext = new ListNode(val);
            minNode.next = minNodeNext;
            minNodeNext.previous = minNode;
            minNode = minNode.next;
        }
        ListNode next = new ListNode(val);
        current.next = next;
        next.previous = current;
        current = next;
    }

    public void pop() {
        if (current.val == minNode.val) {
            minNode = minNode.previous;
            minNode.next = null;
        }
        current = current.previous;
        current.next = null;
    }

    public int top() {
        return current.val;
    }

    public int getMin() {
        return minNode.val;
    }

    public static class ListNode {
        int val;
        ListNode previous;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode previous, ListNode next) {
            this.val = val;
            this.previous = previous;
            this.next = next;
        }
    }
}
