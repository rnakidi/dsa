938. Range Sum of BST - https://leetcode.com/problems/range-sum-of-bst/ - EASY

BFS:
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null == root) {
            return 0;
        }

        int rangeSum = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);        
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.val >= low && node.val <= high) {
                    rangeSum += node.val;
                }

                if (null != node.left) {
                    que.offer(node.left);
                }

                if (null != node.right) {
                    que.offer(node.right);
                }
            }
        }
        return rangeSum;
    }
}

DFS:
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;

        // If root's value is within the range, add it to the sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // Recurse left if there's a chance of finding values within the range
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // Recurse right if there's a chance of finding values within the range
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
