203. Remove Linked List Elements - https://leetcode.com/problems/remove-linked-list-elements/description/ - EASY
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
    public ListNode removeElements(ListNode head, int val) {
         while (null != head && val == head.val) {
                head = head.next;
        }
        
        if (null == head) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (null != fast) {
            if (val == fast.val) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
         }
        return head;
    }
}
