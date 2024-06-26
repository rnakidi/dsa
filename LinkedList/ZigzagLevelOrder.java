103. Binary Tree Zigzag Level Order Traversal
Description
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

Solution (T:O(n), S:O(n)) - BFS
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }

        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] nodes = new Integer[size];
            for (int i = 0; i < size; i++) {
                int index = leftToRight ? i : (size - 1 - i);
                TreeNode node = queue.poll();
                nodes[index] = node.val;
                if (null != node.left) {
                    queue.add(node.left);
                }

                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            ans.add(Arrays.asList(nodes));
            leftToRight = !leftToRight;
        }

        return ans;
    }
}
