https://leetcode.com/problems/first-missing-positive/description/

class  FirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
		if (null == nums || 0 == nums.length) {
			return -1;
		}
		
		// Use Cycle sort - place the numbers at right index by swapping them
		int len = nums.length;
		int i = 0;
		while (i < len) {
			int correctIndex = nums[i] - 1;
			if (nums[i] > 0 && nums[i] < len && nums[i] != nums[correctIndex]) {
				swap(nums, i, correctIndex);
			} else {
				i++;
			}
		}
		
		for (i = 0; i < len; i++) {
			if (nums[i] != i + 1) {
				return i +1;
			}
		}
		
		return len + 1;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

public class FirstMissingPositiveTest {

	public static void main(String[] args) {
		
		int[] nums = {1,2,0};
		FirstMissingPositive fmp = new FirstMissingPositive();
		System.out.println(fmp.firstMissingPositive(nums));
		
		int[] nums1 = {3,4,-1,1};
		System.out.println(fmp.firstMissingPositive(nums1));
		
		int[] nums2 = {7,8,9,11,127,8,9,11,12};
		System.out.println(fmp.firstMissingPositive(nums2));

	}
}
