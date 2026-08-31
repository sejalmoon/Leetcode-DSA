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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};

        int minDist = Integer.MAX_VALUE;

        ListNode prevNode = head;
        ListNode currNode = head.next;
        int currInd = 1;
        int prevCritInd = 0;
        int firstCritInd = 0;

        while(currNode.next != null){
            if((currNode.val < prevNode.val && currNode.val < currNode.next.val) || (currNode.val > prevNode.val && currNode.val > currNode.next.val)){
                if(prevCritInd == 0){
                    prevCritInd = currInd;
                    firstCritInd = currInd;
                }else{
                    minDist = Math.min(minDist, currInd - prevCritInd);
                    prevCritInd = currInd;
                }
            }
            currInd++;
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(minDist != Integer.MAX_VALUE){
            int maxDist = prevCritInd - firstCritInd;
            result = new int[]{minDist, maxDist};
        }
        return result;
    }
}