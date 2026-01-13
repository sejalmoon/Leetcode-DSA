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
    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = new ListNode(0, head);
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        while(head1 !=null && head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }    

        if(head1 != null){
            temp.next = head1;
        }
        if(head2 != null){
           temp.next = head2;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        //using merge sort
        if(head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode lefthead = head;
        ListNode righthead = middle.next;
        middle.next = null;
        lefthead = sortList(lefthead);
        righthead = sortList(righthead);
        return merge(lefthead, righthead);
    }
}