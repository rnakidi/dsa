5. Longest Palindromic Substring - https://leetcode.com/problems/longest-palindromic-substring/description/
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
	
class Solution {
	private int len;
	private int head;
    public String longestPalindrome(String s) {
	    if (null == s) {
		    return "";
	    }
	    
	    if (s.length() < 2) {
		    return s;
	    }

	    len = Integer.MAX_VALUE;
	    head = 0;
	    helper(s, 0);
	    return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
	
    private void helper(String s, int l) {
	    if (l == s.length()) {
		    return;
	    }
	    
	    for (int i = l; i < s.length(); i++) {
		    if (isPalindrome(s, l, i)) {
			    if (i - l + 1 > len) { // end - begin + 1
				    len = i - l + 1;
				    head = l;
			    }
			    helper(s, i+1);
		    }
	    }
    }

    private boolean isPalindrome(String s, int l, int r) {
	    while (l <= r) {
		    if (s.charAt(l) != s.charAt(r)) {
			    return false;
		    }
		    l++;
		    r--;
	    }
	    return true;
    }
 }
}

BRUTE FORCE APPROACH:
class Solution {
    public String longestPalindrome(String s) {
        if (null == s) {
			return "";
		}
		
		if (s.length() < 2) {
			return s;
		}
		
		int len = Integer.MIN_VALUE;
		int head = 0;
		for (int begin = 0; begin < s.length(); begin++) {
			for (int end = begin; end < s.length(); end++) {
				if (isPalindrome(s, begin, end)) {
					if (end - begin + 1 > len) {
						len = end - begin + 1;
						head = begin;
					}
				}
			}
		}
		
		return len == Integer.MIN_VALUE ? "" : s.substring(head, head + len);

    }
}

ANOTHER APPROACH - (O(n2)): 
int len = MAX_VALUE;
int head = 0;
for (int i= 0; i < str.length(); i++) {
	palinHelper(str, i, i);
	palinHelper(str, i, i+1);
}

Apply the following login inside - palinHelper method
if (isPalindrome(s, begin, end)) {
	if (end - begin + 1 > len) {
		len = end - begin + 1;
		head = begin;
	}
}

