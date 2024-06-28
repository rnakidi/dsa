515. Find Largest Value in Each Tree Row

Description:
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
  
Example 2:

Input: root = [1,2,3]
Output: [1,3]
 
Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1

Solution(T:O(n), S:O(n))
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
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
    	util(root, ans, 0);
    	return ans;
    }
    
    private void util(TreeNode root, List<Integer> ans, int level) {
    	if (null == root) {
    		return;
    	}
    	
    	if (level == ans.size()) {
    		ans.add(root.val);
    	} else {
    		ans.set(level, Math.max(root.val, ans.get(level)));
    	}
    	
		util(root.left, ans, level + 1);
		util(root.right, ans, level + 1);
    }
}

Solution(T:O(n^2), S:O(n))
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if (null != node.left) {
                    q.add(node.left);
                }

                if (null != node.right) {
                    q.add(node.right);
                }
            }
            ans.add(max);
        }

        return ans;
    }
}
