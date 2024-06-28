662. Maximum Width of Binary Tree
Description
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:

Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:

Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2). 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100

Solution (T:O(n), S:O(w))
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
    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(max, size);
            while(size-- > 0) {
                TreeNode node = q.poll();
                if (null != root.left) {
                    q.add(root.left);
                }

                if (null != root.right) {
                    q.add(root.right);
                }
            }
        }

        return max;
    }
}

Solution (T:O(n^2), S:O(1))
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
    public int widthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int h = height(root);
        for (int i = 0; i < h; i++) {
            int w = getWidth(root, i);
            max = Math.max(max, w);
        }

        return max;
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
    private int getWidth(TreeNode root, int level) {
        if (null == root) {
            return 0;
        }

        if (0 == level) {
            return 1;
        } else if (level > 0) {
            return (getWidth(root.left, level - 1)
             + getWidth(root.right, level - 1));
        }

        return 0;
    }
}
