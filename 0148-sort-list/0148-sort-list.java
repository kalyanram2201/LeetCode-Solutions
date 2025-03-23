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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        mergeSort(list, 0, list.size() - 1);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : list) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }

    private void mergeSort(List<Integer> list, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private void merge(List<Integer> list, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] result = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (list.get(i) <= list.get(j)) {  
                result[k++] = list.get(i++);
            } else {
                result[k++] = list.get(j++);
            }
        }

        while (i <= mid) {
            result[k++] = list.get(i++);
        }
        while (j <= right) {  
            result[k++] = list.get(j++);
        }

        for (k = 0; k < result.length; k++) {
            list.set(left + k, result[k]);
        }
    }
}
