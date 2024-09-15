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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     if(head.next==null){
         return null;
     }
     int size=0;
     ListNode temp=head;
     while(temp!=null){
        temp=temp.next;
        size++;
     }
     if(n==size){
        return head.next;
     }
     int x=size-n;
     ListNode node=head;
     int cn=1;
     while(cn!=x){
        node=node.next;
        cn++;
     }
     node.next=node.next.next;
     return head;
    }
}