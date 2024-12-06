435. Non-overlapping Intervals - https://leetcode.com/problems/non-overlapping-intervals/description/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (null == intervals || intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (isOverLap(prev, cur)) {
                count++;
                if (prev[1] >= cur[1]) {
                    prev = cur;
                }
            } else {
                prev = cur;
            }
        }
        return count;
    }

    private boolean isOverLap(int[] prev, int[] cur) {
        return cur[0] < prev[1];
    }
}
