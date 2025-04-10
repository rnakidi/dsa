105. Construct Binary Tree from Preorder and Inorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=problem-list-v2&envId=array
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

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
	int idx;
	Map<Integer, Integer> table = new HashMap<>();
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	idx = 0;
        for (int i = 0; i < inorder.length; i++) {
        	table.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int low, int high) {
    	if (low > high) {
    		return null;
    	}
    	int val = preorder[idx++];
    	int id = table.get(val);
    	TreeNode root = new TreeNode(val);
    	root.left = buildTree(preorder, low, id - 1);
    	root.right = buildTree(preorder, id + 1, high);
    	return root;
    }
}
