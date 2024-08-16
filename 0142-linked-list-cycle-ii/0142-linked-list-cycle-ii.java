/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int lengthCycle(ListNode head){
        ListNode f=head;
        ListNode s=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
            if(f==s){
                ListNode temp=s;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=s);
                return length;
            }
        }
        return 0;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode f=head;
        ListNode s=head;
        int length=0;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
            if(f==s){
                length=lengthCycle(s);
                break;
            }
        }
        if(length==0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(length>0){
            slow=slow.next;
            length--;
        }
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}