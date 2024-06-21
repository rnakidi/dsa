61. Rotate List
Description
Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
  
Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109

Solution (T:O(n), S:O(1))
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
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next || k < 1) {
            return head;
        }

        int len = 0;
        ListNode temp = head;
        while (null != temp) {
            temp = temp.next;
            len++;
        }

        // Normalize k in case it's larger than the list's length
        k %= len;
        if (0 == k) {
            return head;
        }

        ListNode fast = head;
        while (k-- > 0 && null != fast) {
            fast = fast.next;
        }

        if (k >= 0 && null == fast) {
            return head;
        }

        ListNode slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
