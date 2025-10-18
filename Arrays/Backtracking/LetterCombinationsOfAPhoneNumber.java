17. Letter Combinations of a Phone Number- https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {
    static Map<Character, String> map = 
        Map.of('2', "abc",
               '3', "def", 
                '4', "ghi",
                '5', "jkl",
                 '6', "mno",
                 '7', "pqrs",
                 '8', "tuv",
                 '9', "wxyz"
                );
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int l, StringBuilder subAns, List<String> ans) {
        if (l == digits.length()) {  // base case
            ans.add(subAns.toString());
            return;
        }

        String letters = map.get(digits.charAt(l));
        // Explore all possibilities
        for (char ch : letters.toCharArray()) {
            subAns.append(ch); // Make a choice
            backtrack(digits, l + 1, subAns, ans); // Explore further
            subAns.deleteCharAt(subAns.length()-1); // Undo or backtrack
        }
    }
}
