Binary Tree Left Side View

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        maxLevel = 0;
        util(root, ans, 1);
        return ans;        
    }

    public void util(TreeNode root, List<Integer> ans, int level) {
        if (null == root) {
            return;
        }

        if (maxLevel < level) {
            ans.add(root.val);
            maxLevel = level;
        }

        util(root.left, ans, level + 1);
        util(root.left, ans, level + 1);        
    }
}
