82. Remove Duplicates from Sorted List II
Description
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
  
Example 2:

Input: head = [1,1,1,2,3]
Output: [2,3] 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

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
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode start = dummy;
        ListNode temp = start.next;
        while (null != temp) {
            while (null != temp.next && temp.val == temp.next.val) {
                temp = temp.next;
            }
            if (start.next == temp) {
                start = temp;
            } else {
                start.next = temp.next;
            }
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
