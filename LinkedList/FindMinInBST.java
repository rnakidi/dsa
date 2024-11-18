Find Min In BST

Solution(T:O(n), S:O(n))

class Solution {
  
	public int findMin(TreeNode root) {
		
		if (null == root) {
			  return Integer.MAX_VALUE;
		}
		
		int min = root.val;
		int leftMin = findMin(root.left);
		int rightMin = findMin(root.right);
		
		if (leftMin < min) {
			min = leftMin;
		}
		
		if (rightMin < min) {
			min = rightMin;
		} 
		// min = Math.min(min, Math.min(leftMin, rightMin));
		return min;		
	}
}
