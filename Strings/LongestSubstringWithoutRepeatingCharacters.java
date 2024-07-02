3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest 
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

Solution-I(T:O(n), S:O(1))
  
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        if (0 == s.trim().length()) {
            return 1;
        }

        int[] map = new int[256];

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;

        while(right < s.length()) {
            char c = s.charAt(right);
            if (map[c]++ > 0) {
                count++;
            }
            right++;

            while(count > 0) {
                c = s.charAt(left);
                if (map[c]-- > 1) {
                    count--;
                }
                left++;     
            }

            max = Math.max(max, right - left);
        }
        
        return max;
    }
}

Solution-II(T:O(n), S:O(n))
class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        if (0 == s.trim().length()) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
        	char ch  = s.charAt(right);
        	while (set.contains(ch)) {
        		set.remove(s.charAt(left));
        		left++;
        	}
        	set.add(ch);
        	max= Math.max(max, right - left + 1);
        	right++;
        }
        
        return max;
    }
}
Solution-III(T:O(n), S:O(1))
class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        if (0 == s.trim().length()) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
        	int index = s.indexOf(s.charAt(right), left);
        	if (index != right) {
        		left = index + 1;
        	}
        	max = Math.max(max, right - left + 1);
        	right++;
        }
        
        return max;
    }
}
