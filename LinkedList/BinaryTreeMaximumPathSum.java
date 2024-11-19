124. Binary Tree Maximum Path Sum - https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        util(root);
        return maxSum;
    }

    private int util(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftMaxSum = Math.max(util(root.left), 0);
        int rightMaxSum = Math.max(util(root.right), 0);
        int curMax = root.val + leftMaxSum + rightMaxSum; // split
        maxSum = Math.max(maxSum, curMax);
        return root.val + Math.max(leftMaxSum, rightMaxSum); // Un split
    }
}
