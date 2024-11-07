2. Add Two Numbers - https://leetcode.com/problems/add-two-numbers/description/ - MEDIUM

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

T(O(n)), S(O(1)):
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        int carry = 0;
        while (null != l1 || null != l2 || 0 != carry) {
            int digit1 = null != l1 ? l1.val : 0;
            int digit2 = null != l2 ? l2.val : 0;
            int sum = digit1 + digit2 + carry;
            digit1 = sum % 10;
            carry = sum / 10;
            temp.next = new ListNode(digit1);
            temp = temp.next;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
        }
        return dummyHead.next;
    }
}
