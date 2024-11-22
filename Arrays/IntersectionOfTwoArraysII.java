350. Intersection of Two Arrays II - https://leetcode.com/problems/intersection-of-two-arrays-ii/ - EASY

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> output = new ArrayList<>();
        for (int num : nums2) {
            int count = countMap.getOrDefault(num, 0);
            if (0 != count) {
                output.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
