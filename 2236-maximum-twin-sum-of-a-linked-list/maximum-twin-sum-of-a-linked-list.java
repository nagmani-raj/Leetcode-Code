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
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = arr.size() - 1;
        int maxSum = 0;

        while (i < j) {
            maxSum = Math.max(maxSum, arr.get(i) + arr.get(j));
            i++;
            j--;
        }

        return maxSum;
    }
}