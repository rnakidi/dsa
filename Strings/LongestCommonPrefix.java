14. Longest Common Prefix - https://leetcode.com/problems/longest-common-prefix/description/ - EASY
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
