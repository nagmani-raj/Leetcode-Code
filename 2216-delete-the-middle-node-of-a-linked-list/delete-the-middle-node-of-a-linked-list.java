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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(slow.next != null && fast.next.next != null &&  fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow.next == null){
            return null;
        }else{
            slow.next = slow.next.next;
        }

        return head;
    }
}