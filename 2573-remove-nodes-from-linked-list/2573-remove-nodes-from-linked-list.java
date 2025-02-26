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
    public ListNode removeNodes(ListNode head) {
        if(head==null){
            return head;
        }
        Stack<Integer> stack=new Stack<>();
        ListNode node=head;
        while(node!=null){
            while(!stack.isEmpty() && stack.peek()<node.val){
                stack.pop();
            }
            stack.push(node.val);
            node=node.next;
        }

        ListNode nhead=null;
        while(!stack.isEmpty()){
            ListNode temp=new ListNode(stack.pop());
            temp.next=nhead;
            nhead=temp;
        }
        return nhead;

    }
}