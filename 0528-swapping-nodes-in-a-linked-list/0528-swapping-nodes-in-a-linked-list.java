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
    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode node = head;

        while (node != null) {
            len++;
            node = node.next;
        }

        ListNode temp1 = head;
        for (int i = 1; i < k; i++) {
            temp1 = temp1.next;
        }

        ListNode temp2 = head;
        for (int i = 1; i < len - k + 1; i++) {
            temp2 = temp2.next;
        }

        int value = temp1.val;
        temp1.val = temp2.val;
        temp2.val = value;

        return head;
    }
}
