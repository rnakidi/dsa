916. Word Subsets
Description
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
  
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.

Solution
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26];
        for (String w2 : words2) {
            int[] tmp = count(w2);
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], tmp[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String w1 : words1) {
            int[] tmp = count(w1);
            int i = 0;
            for (; i < 26; i++) {
                if (tmp[i] < count[i]) {
                    break;
                }
            }
            if (i == 26) {
                ans.add(w1);
            }
        }
        return ans;
    }

    private int[] count(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        return count;
    }
}
