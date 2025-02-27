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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        List<Integer>list=new ArrayList<>();
        for(ListNode node:lists){
            merge(list,node);
        }
        Collections.sort(list);
        if(list.isEmpty()){
            return null;
        }
        ListNode head=new ListNode(list.get(0));
        ListNode node=head;
        for(int i=1;i<list.size();i++){
            node.next=new ListNode(list.get(i));
            node=node.next;
        }
        node.next=null;
        return head;
    }

    void merge(List<Integer> list,ListNode node)
    {
        while(node!=null){
            list.add(node.val);
            node=node.next;
        }
    }
}