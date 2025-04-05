131. Palindrome Partitioning
Description
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.

Solution
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (null == s || 0 == s.length()) {
            return results;
        }

        List<String> subSet = new ArrayList<>();
        helper(s, subSet, results, 0);
        return results;
    }

    private void helper(String s, List<String> subSet, List<List<String>> results, int index) {
        if (index == s.length()) {
           results.add(new ArrayList<>(subSet)) ;
           return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                subSet.add(s.substring(index, i+1)); // Place string
                helper(s, subSet, results, i+1); // Recursively solve for next position
                subSet.remove(subSet.size() - 1); // Backtrack: remove string for trying next position
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
