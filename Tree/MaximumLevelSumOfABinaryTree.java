1161. Maximum Level Sum of a Binary Tree - https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/ - MEDIUM
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
    public int maxLevelSum(TreeNode root) {
        if (null == root ) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            level += 1;
            int size = que.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode temp = que.poll();
                sum += temp.val;
                if (null != temp.left) {
                    que.add(root.left);
                }
                if (null != temp.right) {
                    que.add(root.right);
                }
            }

            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
