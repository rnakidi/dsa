19. Remove Nth Node From End of List
Description
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
  
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

Follow up: Could you do this in one pass?

Solution (T:O(N), S:O(1))
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
        if (null == head) {
            return null;
        }

        ListNode fast = head;
        while (n--> 0 && null != fast) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        if (null == fast) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }
}
