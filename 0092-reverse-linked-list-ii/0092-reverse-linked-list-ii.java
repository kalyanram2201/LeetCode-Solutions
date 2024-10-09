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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }

        ListNode node=head;
        ListNode prev=null;
        for(int i=0;node!=null&&i<left-1;i++){
            prev=node;
            node=node.next;
        }

        ListNode last=prev;
        ListNode newnode=node;

        ListNode next=node.next;
        for(int i=0;node!=null && i<right-left+1;i++){
                node.next=prev;
                prev=node;
                node=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }
            else{
                head=prev;
            }
            newnode.next=node;
            return head;
    }
}