39. Combination Sum - https://leetcode.com/problems/combination-sum/description/

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 
Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

Visualization:
Decision Tree for candidates = [2, 3, 6, 7] and target = 7:
                      []
                    /   \
                 [2]     []
                /   \      \
             [2,2]   [2]    [3]
            /   \       \     \
        [2,2,2]  [2,2,3]  [3,3] [7]
	
Valid combinations: [2, 2, 3], [7]

T: O(2^n), S: O(n)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
				subResult.add(nums[i]); // Explore or make a choice
				combinationSum(nums, i, target - nums[i] , subResult, result); // Explore further; not i + 1 because we can reuse same elements
				subResult.remove(subResult.size() - 1); // Undo - backtrack
			}
		}
	}
}
