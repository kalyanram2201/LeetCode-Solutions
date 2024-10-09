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
      public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode node=dummy;

        while(node!=null){
            ListNode temp=node.next;
            ListNode next=null;
            if(temp!=null){
                next=temp.next;
            }
            if(next!=null){
                ListNode last=next.next;
                next.next=temp;
                node.next=next;
                temp.next=last;
                node=temp;
            }else{
                break;
            }

        }
        return dummy.next;

  }
}