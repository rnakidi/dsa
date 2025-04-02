409. Longest Palindrome - https://leetcode.com/problems/longest-palindrome/description/
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

class Solution {
    public int longestPalindrome(String s) {
        var countMap = new HashMap<Character, Long>();
	for (char ch : s.toCharArray()) {
		countMap.put(ch,  countMap.getOrDefault(ch, 0l) + 1);
	}
		
	int ans = 0;
	int oddCount = 0;
	for (long value : countMap.values()) {
		if (value % 2 == 0) { // even
			ans += value;
		} else {
			ans += value - 1;
			oddCount++;
		}
	}
		
	if (oddCount > 0) {
		ans += 1;
	}
		
	return ans;
  }
}
