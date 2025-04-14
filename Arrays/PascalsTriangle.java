118. Pascal's Triangle - https://leetcode.com/problems/pascals-triangle/description/
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:

1 <= numRows <= 30
  
  class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> rows = new ArrayList<>();
    	for (int row = 0; row < numRows; row++) {
    		var subRow = new ArrayList<Integer>();
    		for (int j = 0; j <= row; j++) {
        		if (0 == j || j == row) {
        			subRow.add(1);
        		} else {
        			int val = rows.get(row-1).get(j-1) + rows.get(row-1).get(j);
        			subRow.add(val);
        		}
    		}
    		rows.add(subRow);
    	}
    	return rows;      
    }
}


  public int[][] generate(int numRows) {
    List<int[]> rows = new ArrayList<>();
    for (int row = 0; row < numRows; row++) {
      var subRow = new int[row + 1];
      for (int j = 0; j <= row; j++) {
          if (0 == j || j == row) {
            subRow[j] = 1;
          } else {
            int val = rows.get(row-1)[j-1] + rows.get(row-1)[j];
            subRow[j] = val;
          }
      }
      rows.add(subRow);
    }
    return rows.toArray(new int[rows.size()][]);
  }
