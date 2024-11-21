242. Valid Anagram - https://leetcode.com/problems/valid-anagram/description/ - EASY

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] map = new char[26];
        for (char ch : s.toCharArray()) {
            map[ch-'a']++;
        }
        
        for (char ch : t.toCharArray()) {
            map[ch-'a']--;
        }

        for (char ch : s.toCharArray()) {
            if (0 != map[ch-'a']) {
                return false;
            }
        }
 
        return true;
    }
}
