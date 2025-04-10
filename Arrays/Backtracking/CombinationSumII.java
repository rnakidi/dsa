40. Combination Sum II - https://leetcode.com/problems/combination-sum-ii/description/
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> subResult = new ArrayList<>();
    	Arrays.sort(candidates); // Sort the candidates array (optional, but ensures combinations are generated in order).
    	combinationSum(candidates, 0, target, subResult, result);
    	return result;
    }

	private void combinationSum(int[] nums, int l, int target, List<Integer> subResult,
			List<List<Integer>> result) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<>(subResult));
		} else {
			// Explore all possibilities
			for (int i = l; i < nums.length; i++) {
				if (i > l && nums[i] == nums[i-1]) { // Skip duplicates
				     continue;
				}
				subResult.add(nums[i]); // Explore or make a choice
				combinationSum(nums, i+1, target - nums[i] , subResult, result); // Explore further
				subResult.remove(subResult.size() - 1); // Undo - backtrack
			}
		}
	}
}
