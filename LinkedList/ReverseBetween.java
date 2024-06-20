

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 0;
        ListNode temp = head;
        ListNode leftNode = null;
        ListNode rightNode = null;\

        while (null != temp) {
            i++;
            if (i == left) {
                leftNode = temp;
            }
            
            if (i == right) {
                rightNode = temp;
            }

            temp = temp.next;
        }
        
        int val = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = val;

        return head;
    }
}
