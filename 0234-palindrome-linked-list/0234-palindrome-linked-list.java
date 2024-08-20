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
    public boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null){
            return true;
        }
        ListNode mid=mid(head);
        ListNode head2=reverse(mid);
        ListNode secondhead=head2; 
        while(head!=null && head2!=null){
            if(head.val!=head2.val){
                break;
            }
            head=head.next;
            head2=head2.next;
        } 
        reverse(secondhead);
        return head==null ||head2==null;
    }
    public ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
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