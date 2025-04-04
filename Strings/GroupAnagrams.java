49. Group Anagrams - https://leetcode.com/problems/group-anagrams/description/?envType=problem-list-v2&envId=array
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

Approach - I:
T: O(n*k), S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      if (0 == strs.length) {
    		return Collections.emptyList();
    	}

    	Map<Integer, List<String>> table = new HashMap<>();
    	for (String str : strs) {
    		int hash = hash(str.getBytes(), str.length());
    		table.compute(hash, (k, v) -> {
    			if (null == v) {
    				v = new ArrayList<>();
    			}
    			
    			v.add(str);
    			return v;
    		});
    	}
    	
    	return table.values().stream().toList();
    }
}

Approach - II:
T: O(nlogn), S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     	if (0 == strs.length) {
    		return Collections.emptyList();
    	}

    	Map<String, List<String>> table = new HashMap<>();
    	for (String str : strs) {
    		char[] s = str.toCharArray();
    		Arrays.sort(s);
    		String temp = String.valueOf(s);
    		/*table.computeIfAbsent(temp, v -> new ArrayList<>());
    		table.get(temp).add(str);*/
    		table.compute(temp, (k, v) -> {
    			if (null == v) {
    				v = new ArrayList<>();
    			}
    			
    			v.add(str);
    			return v;
    		});
    	}
    	
    	return table.values().stream().toList();
    }
}
