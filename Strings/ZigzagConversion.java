6. Zigzag Conversion - https://leetcode.com/problems/zigzag-conversion/description/
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000

class Solution {
    public String convert(String s, int numRows) {
        if (null == s || s.isBlank() 
            || 1 == numRows || numRows > s.length()) {
    		    return s;
    	}
    	
    	List<Character>[] rows = new ArrayList[numRows];
    	for (int i = 0; i < numRows; i++) {
    		rows[i] = new ArrayList<>();
    	}        
    	
    	int idx = 0;
    	int d = 1;
    	for (char ch : s.toCharArray()) {
    		rows[idx].add(ch);
    		if (idx == 0) {
    			d = 1;
    		} else if (idx == numRows - 1) {
    			d = -1;
    		}
    		idx += d;
    	}
    	
    	return Stream.of(rows)
            .flatMap(x -> x.stream())
                .collect(StringBuilder::new, 
                StringBuilder::append, StringBuilder::append).toString();
    }
}
