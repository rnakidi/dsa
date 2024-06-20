1721. Swapping Nodes in a Linked List

Description:

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).


Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
  
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100

Solution:

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
    public ListNode swapNodes(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode rightNode = null;
        ListNode leftNode = null;
        while(k-- > 0 && null != fast) {
            rightNode = fast;
            fast = fast.next;
        }
        
        if (null == fast) {
            int v = head.val;
            head.val  = rightNode.val;
            rightNode.val = v;
            return head;
        }
        
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        leftNode = slow.next;
        int right = rightNode.val;
        rightNode.val = leftNode.val;
        leftNode.val = right;

        return head;
    }
}
