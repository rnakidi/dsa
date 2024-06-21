143. Reorder List
Description
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]
  
Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

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
    public void reorderList(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) { // One or two nodes in the list
            return;
        }

        // Find middle of the list
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = reverse(slow.next); // Reverse list
        slow.next = null;
        ListNode l1 = head;
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        while (null != l1 || null != l2) { // Merge list
            if (null != l1) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }

            if (null != l2) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        head = newHead.next;
   }

   public ListNode reverse(ListNode head) {
        ListNode one = head;
        ListNode two = null;
        ListNode three = null;
        while (null != one) {
            three = one.next;
            one.next = two;
            two = one;
            one = three;
        }
        return two;
   }
}
