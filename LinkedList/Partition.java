86. Partition List

Decsription:
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 
Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200

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
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return null;
        }

        ListNode temp = head;
        ListNode beforeHead = new ListNode(-1);
        ListNode afterHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        while (null != temp) {
            if (temp.val < x) {
                before.next = temp;
                before = temp;
            } else {
                after.next = temp;
                after = temp;
            }
            temp = temp.next;
        }

        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
