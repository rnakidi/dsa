90. Subsets II - https://leetcode.com/problems/subsets-ii/description/
NOTE: This is a BACKTRACKING problem - A TEMPLATE similar to PERMUNTATION will be used to solve this.
 
Description
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
  
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

Solution
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        helper(nums, 0, subSet, ans);
        return ans;
    }
    
    private void helper(int[] nums, int index, List<Integer> subSet, List<List<Integer>> ans) {

        if (!ans.contains(subSet)) {
            ans.add(new ArrayList<>(subSet));
        }        

        for (int i = index; i< nums.length; i++) {
            subSet.add(nums[i]);
            helper(nums, ans, subSet, i + 1);
            subSet.remove(subSet.size() - 1);
        }
    }
}
