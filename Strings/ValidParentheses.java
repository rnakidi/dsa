20. Valid Parentheses - https://leetcode.com/problems/valid-parentheses/description/ - EASY

class Solution {
    public boolean isValid(String s) {
        if (1 == s.length()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ('(' == ch) {
                stack.push(')');
            } else if ('{' == ch) {
                stack.push('}');
            } else if ('[' == ch) {
                stack.push(']');
            } else if (stack.isEmpty() || ch != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
