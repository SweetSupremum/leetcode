package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * {@see https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150}
 *
 * @author SweetSupremum
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> oldNewMap = new HashMap<>();
        Node temp = head;
        while (head.next != null) {
            oldNewMap.put(head, new Node(head.val));
            head = head.next;
        }
        head = temp;
        while (head != null) {
            Node copyNext = oldNewMap.get(head.next);
            Node copyRandom = oldNewMap.get(head.random);
            Node newCurrent = oldNewMap.get(head);
            newCurrent.next = copyNext;
            newCurrent.random = copyRandom;
            head = head.next;
        }
        return oldNewMap.get(temp);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
