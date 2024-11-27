57. Insert Interval - https://leetcode.com/problems/insert-interval/description/ - MEDIUM

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int i = -1;
        for (int[] interval : intervals) {
            i += 1;
            if (newInterval[1] < interval[0]) {
                results.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    results.add(intervals[j]);
                }

                return results.toArray(new int[results.size()][]);
            } else if (newInterval[0] > interval[1]) {
                results.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        results.add(newInterval);
        return results.toArray(new int[results.size()][]);
    }
}
