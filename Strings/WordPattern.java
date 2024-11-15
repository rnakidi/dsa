290. Word Pattern - https://leetcode.com/problems/word-pattern/description/ - EASY
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];            
            if (!charMap.containsKey(ch)) {
                charMap.put(ch, word);
            }
            
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, ch);
            }

            if (!charMap.get(ch).equals(word) || !wordMap.get(word).equals(ch)) {
                return false;
            }
        }
        return true;
    }
}
