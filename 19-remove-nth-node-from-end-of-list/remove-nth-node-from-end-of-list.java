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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode start = temp;

        for(int i = 0; i<n; i++){
            head = head.next;
        }

        while(head != null){
            head = head.next;
            start = start.next;
        }

        start.next = start.next.next;

        return temp.next;
    }
}