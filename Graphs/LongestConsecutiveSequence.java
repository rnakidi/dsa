128. Longest Consecutive Sequence - https://leetcode.com/problems/longest-consecutive-sequence/description/ - MEDIUM

class Solution {
    public int longestConsecutive(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        int count = 1;
        int max = 0;
        int prev = pq.poll();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur - prev == 1) {
                count++;
            } else if (cur - prev > 1) {
                max = Math.max(max, count); // Max sofar before reset
                count = 1; // Reset
            }
            prev = cur;
        }

        return Math.max(max, count);
    }
}
