47. Permutations II
Description
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

Solution(T:O(n!), S:O(n!))
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, 0); // starting with index = 0
        return ans; 
    }

    private void permute(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            List<Integer> subSet = new ArrayList<>();
            for (int num : nums) {
                subSet.add(num);
            }
            //if (!ans.contains(subSet)) {
                ans.add(subSet);
            //}
             return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i != index && !canPermute(nums, index, i)) {
                continue;
            }
            swap(nums, index, i);
            permute(nums, ans, index+1);
            swap(nums, index, i);
        }
    }

    private boolean canPermute(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] == nums[h]) {
                return false;
            }
         }
        return true;
    }
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
  
