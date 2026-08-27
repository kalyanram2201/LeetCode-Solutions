/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return null;

        int length = 0;
        ListNode node = head;

        while (node != null) {
            length++;
            node = node.next;
        }

        int mid = length / 2;
        node = head;

        for (int i = 0; i < mid - 1; i++) {
            node = node.next;
        }

        node.next = node.next.next;

        return head;
    }
}