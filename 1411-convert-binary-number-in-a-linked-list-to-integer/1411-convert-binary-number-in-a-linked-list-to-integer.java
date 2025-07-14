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
    public int getDecimalValue(ListNode head) {
        if (head == null || head.next == null) {
            return head.val;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        //System.out.println("Length="+length);
        node = head;
        int sum = 0;
        for (int i = 1; i <= length; i++) {
            int y = length - i;
            sum += (node.val * pow(2, y));
            //System.out.println(sum);
            node = node.next;
        }
        return sum;
    }

    public int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int pro = 1;
        for (int i = 0; i < y; i++) {
            pro = pro * x;
        }
        return pro;
    }
}