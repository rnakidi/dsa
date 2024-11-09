237. Delete Node in a Linked List - https://leetcode.com/problems/delete-node-in-a-linked-list/description/ - MEDIUM
T(O(1)), S(O(0)):
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (null == node) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
