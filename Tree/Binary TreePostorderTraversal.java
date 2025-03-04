145. Binary Tree Postorder Traversal - https://leetcode.com/problems/binary-tree-postorder-traversal/description/ - EASY
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (null == root) {
            return output;
        }

        helper(root, output);
        return output;
    }

    private void helper(TreeNode root, List<Integer> output) {
        if (null == root) {
            return;
        }

        helper(root.left, output);
        helper(root.right, output);
        output.add(root.val);
    }
}
