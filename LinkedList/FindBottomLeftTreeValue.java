513. Find Bottom Left Tree Value
Description:
Given the root of a binary tree, return the leftmost value in the last row of the tree.

Example 1:

Input: root = [2,1,3]
Output: 1
Example 2:

Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

Solution(T:O(n), S:O(1)) - DFS
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
    static int maxLevel;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        maxLevel = 0;
        res = root.val;
        util(root, 1);

        return res;  
    }

    public void util(TreeNode root, int level) {
        if (null == root) {
            return;
        }

        if (maxLevel < level) {
            res = root.val;
            maxLevel = level;
        }

        util(root.left, level + 1);
        util(root.right, level + 1);
    }
}

Solution(T:O(n), S:O(1)) - BFS
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return -1;
        }
        
        int res = root.val;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            
            if (null != node.left) {
                que.add(node.left);
                res = node.left.val;
            }

            if (null != root.right) {
                que.add(root.right);
            }
        }
                
        return res;
    }    
}

