Find Max In BST

Solution(T:O(n), S:O(n))
  
class Solution {
	
	public int findMax(TreeNode root) {
		
		if (null == root) {
			return Integer.MIN_VALUE;
		}
		
		int max = root.val;
		int leftMax = findMax(root.left);
		int rightMax = findMax(root.right);
		
		if (leftMax > max) {
			max = leftMax;
		}
		
		if (rightMax > max) {
			max = rightMax;
		}
		
		return max;		
	}
}
