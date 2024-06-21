25. Reverse Nodes in k-Group
  Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
  
Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000

Follow-up: Can you solve the problem in O(1) extra memory space?

Solution
  
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
        if (null == head || null == head.next) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;
        ListNode end = start.next;
        int count = 1;
        while (null != end) {
            if (count % k == 0) {
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
            count++;
        }

        return dummy.next;        
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode one = start.next;
        ListNode two = start;
        ListNode first = one;
        ListNode three = null;
        while (one != end) {
            three = one.next;
            one.next = two;
            two = one;
            one = three;
        }
        start.next = two;
        first.next = one;

        return first;
    }
}
