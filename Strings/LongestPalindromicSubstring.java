5. Longest Palindromic Substring - https://leetcode.com/problems/longest-palindromic-substring/description/
  
class Solution {
    public String longestPalindrome(String s) {
    if (null == s) {
			  return "";
		}
		
		if (s.length() < 2) {
			return s;
		}
		
		helper(s, 0);
		
		return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
	}

	private void helper(String s, int l) {
		if (l == s.length()) {
			return;
		}
		
		for (int i = l; i < s.length(); i++) {
			if (isPalindrome(s, l, i)) {
				if (i - l + 1 > len) {
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
