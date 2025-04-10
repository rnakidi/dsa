Input: int[][] nums = subArraySum(new int[] {1,4,20,3,10,5,15}, 33); O/P: [2, 4] [3, 6] , which is [[20,3,10],[3,10,5,15]]

class Solution {
    public List<List<String>> solveNQueens(int n) {
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
            sum -= nums[left];
            left++;
          }
        right++;
  		}		
    }
}
