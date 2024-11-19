387. First Unique Character in a String - https://leetcode.com/problems/first-unique-character-in-a-string/description/ - EASY

class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int['z' + 1];
        char[] letters = s.toCharArray();
        for (char ch : letters) {
            map[ch]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (1 == map[letters[i]]) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }
}
