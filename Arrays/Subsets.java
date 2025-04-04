Subsets : https://leetcode.com/problems/subsets/
NOTE: BACKTRACKING problem use the template of Palndrome partioning(uses permutaation patter).
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        backtrack(nums, 0, subSet, ans);
        return ans;
    }
}

private void backtrack(int[] nums, int l, List<Integer> subSet, List<List<Integer>> ans){
    list.add(new ArrayList<>(subSet));
    for(int i = l; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
