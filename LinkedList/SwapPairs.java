24. Swap Nodes in Pairs
Description
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]
  
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100

Solution (T: O(n), S: O(1))
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
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;
        ListNode end = start.next;
        int count = 1;

        while (null != end) {
            if (0 == count%2) {
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
        ListNode one  = start.next;
        ListNode two = start;
        ListNode first = one;
        ListNode three = null;
        while(one != end) {
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
