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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null){
            ListNode kNode = findKNode(temp, k);
            if(kNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kNode.next;
            kNode.next = null;
            reverse(temp);

            if(temp == head){
                head = kNode;
            }else{
                prevNode.next = kNode;
            }

            prevNode = temp;
            temp = nextNode;

        }
        return head;
    }

    private void reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    private ListNode findKNode(ListNode head, int k){
        int count = 0;
        while(head != null){
            count++;
            if(count == k){
                return head;
            }
            head=head.next;
        }
        return null;
    }
}