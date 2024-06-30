112. Path Sum
Description
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths. 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

Solution(0ms - DFS - T:O(n), S:O(n)
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if (null == root)
       {
          return false;
       }
       targetSum -= root.val;
       if (null == root.left && null == root.right)
       {
        return (0 == targetSum);
       } 
       return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

Solution(1ms - bfs - Queue - T:O(n), S:O(n)
Java
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(root.val);
        
        while(!q1.isEmpty()){
            int n = q1.size();

            for(int i = 0; i < n; i++){
                TreeNode node = q1.poll();
                int pathSum = q2.poll(); 
                 
                if(pathSum == targetSum && node.left == null && node.right == null)
                {
                    return true;
                }
                if(node.left != null){
                    q1.add(node.left);
                    q2.add(pathSum + node.left.val);
                }
                if(node.right != null){
                    q1.add(node.right);
                    q2.add(pathSum + node.right.val);
                }
                
            }
        }
        return false;
    }
}

Solution(2ms - BFS - Stack - T:O(n), S:O(n))
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        sums.push(root.val);
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int sum = sums.pop();
            if (sum == targetSum && null == node.left && null == node.right) {
                return true;
            }

            if (null != node.left) {
                stack.push(node.left);
                sums.push(sum + node.left.val);
            }

            if (null != node.right) {
                stack.push(node.right);
                sums.push(sum + node.right.val);
            }
        }

        return false;
    }
}

Solution(1ms - BFS - Queue - T:O(n), S:O(n))
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        Queue<TreeNode> que = new LinkedList<>();
        Queue<Integer> sums = new LinkedList<>();
        sums.add(root.val);
        que.add(root);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();
            int sum = sums.poll();
            if (sum == targetSum && null == node.left && null == node.right) {
                return true;
            }

            if (null != node.left) {
                que.add(node.left);
                sums.add(sum + node.left.val);
            }

            if (null != node.right) {
                que.add(node.right);
                sums.add(sum + node.right.val);
            }
        }

        return false;
    }
}
