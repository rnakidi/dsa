46. Permutations
Description
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

Solution-I:
  class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return results;
        }

        helper(nums, results, 0);
        return results;
    }

    private void helper(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (index != i && !canPermute(nums, index, i)) {
                continue;
            }
            swap(nums, index, i);
            helper(nums, ans, index+1);
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private boolean canPermute(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] == nums[h]) {
                return false;
            }
        }

        return true;
    }
}

Solution-II:
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return results;
        }

        helper(nums, results, 0, nums.length - 1);
        return results;
    }

    private void helper(int[] nums, List<List<Integer>> ans, int l, int r) {
        if (l == r) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(nums, l, i);
            helper(nums, ans, l+1, r);
            swap(nums, l, i);
        }

    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}  
