139. Word Break
Description
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
  
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

Solution(Recusrion(DFS) + Memorization))
Complexity
Time complexity: ( O(n * m + k) ), where ( n ) is the length of the string, ( m ) is the maximum length of a word in the dictionary, and ( k ) is the total number of characters in all words in the dictionary (for building the Trie).
Space complexity: ( O(n + k) ), where ( n ) is the length of the string and ( k ) is the total number of characters in all words in the dictionary.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, memo);
    }
    
    private boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        if (wordSet.contains(s)) return true;
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) && dfs(s.substring(i), wordSet, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}  
