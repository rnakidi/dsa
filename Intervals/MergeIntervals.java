56. Merge Intervals - https://leetcode.com/problems/merge-intervals/description/ - MEDIUM

class Solution {
    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] newInt = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (isOverLap(newInt, cur)) {
                newInt[1] = Math.max(newInt[1], cur[1]); // Merge
            } else {
                res.add(newInt);
                newInt = cur;
            }
        }
        res.add(newInt); // At the end
        return res.toArray(new int[res.size()][]);
    }

    private boolean isOverLap(int[] newInt, int[] cur) {
        return cur[0] <= newInt[1];
    }
}
