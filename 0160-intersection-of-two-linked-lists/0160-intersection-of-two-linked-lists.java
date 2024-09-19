/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null && headB==null){
            return null;
        }
        ListNode temp=headB;
        while(temp!=null){
            ListNode node=headA;
            while(node!=null){
                if(node==temp){
                    return temp;
                }
                node=node.next;
            }
            temp=temp.next;
        }
        return null;
    }
}