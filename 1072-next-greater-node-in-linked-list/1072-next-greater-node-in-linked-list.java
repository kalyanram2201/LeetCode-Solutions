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
    public int[] nextLargerNodes(ListNode head) {
        if(head==null){
            return new int[0];
        }
        List<Integer>list=new ArrayList<>();
        ListNode node=head;
        while(node!=null){
            int val=node.val;
            int max=0;
            ListNode temp=node.next;
            while(temp!=null){
                if(val<temp.val){
                    max=temp.val;
                    break;
                }
                temp=temp.next;
            }
            list.add(max);
            node=node.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}