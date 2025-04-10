Input: int[][] nums = subArraySum(new int[] {1,4,20,3,10,5,15,3}, 33); O/P: [2, 4] [3, 6], which is [[20,3,10],[3,10,5,15], [4, 7]]
Input: int[][] nums1 = subArraySum(new int[] {1,1,1}, 2); O/P: [0, 1] [1, 2], which is [[1,1],[1,1]]

class Solution {
    public int[][] subArraySum(int[] nums, int target) {
  		int left = 0;
  		int right = 0;
  		int sum = 0;
  		List<int[]> res = new ArrayList<>();
  		while (right < nums.length) {
    			sum += nums[right];
    			while (sum > target && left <= right) {
    			    sum -= nums[left];
    			    left++;
    			}
  			
    			if (sum == target) {
    			    res.add(new int[] {left, right});
    			    sum -= nums[left]; // This line and the below one is optional but nice to have
    			    left++;
    			}
    			right++;
  		}
  		return res.toArray(new int[res.size()][]);
    }
}
