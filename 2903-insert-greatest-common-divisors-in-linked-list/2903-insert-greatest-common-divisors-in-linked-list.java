class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        
        while (node != null && node.next != null) {
            int val1 = node.val;
            int val2 = node.next.val;
            int gcd = GCD(val1, val2);
            ListNode temp = new ListNode(gcd);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        return head;
    }

    private int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
