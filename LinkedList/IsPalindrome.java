234. Palindrome Linked List
Description
  
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
  
Example 2:

Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
  
Solution (O(n), O(1)
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
    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (null != fast) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;
        while (null != slow) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;        
    }

    public ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }

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

Solution (O(n), O(n)
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
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        int size = 0;
        int ans[] = new int[100_000];
        ListNode temp = head;
        while (null != temp) {
            ans[size++] = temp.val;
            temp = temp.next;
        }

        int mid = size/2;
        int i = 0;
        while (i < mid) {
            if (ans[i++] != ans[--size]) {
                return false;
            }
        }

        return true;
    }
}
