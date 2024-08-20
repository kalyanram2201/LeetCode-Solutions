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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid = mid(head);
        ListNode fh=head;
        ListNode sh=reverseList(mid);
        while(fh!=null && sh!=null){
            ListNode temp=fh.next;
            fh.next=sh;
            fh=temp;
            temp=sh.next;
            sh.next=fh;
            sh=temp;
        }
        if(fh!=null){
            fh.next=null;
        }
    }
    public ListNode mid(ListNode head){
       ListNode s =head;
       ListNode f =head;
       while(f!=null && f.next!=null){
           s=s.next;
           f=f.next.next;
        }
        
       return s;
    }
    
    public ListNode reverseList(ListNode head){
    
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode current=head;
        ListNode next=current.next;
        while(current!=null){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }
}