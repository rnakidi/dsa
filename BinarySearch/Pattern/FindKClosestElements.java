658. Find K Closest Elements
Description
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. 
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4] 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
  
Solution-I(T(logN), S:O(1), 3ms)
  class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        while (low < high) {
            int mid = (low + high)/2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        while (k-- > 0) {
            ans.add(arr[low]);
            low++;
        }

        return ans;
    }
}

Note: Line #42-45, will take most of time to construct the output list. So, if we replace this by user defined list then it will take almost 0 ms.
  return new IntList(arr, left, k);
    private static final class IntList extends java.util.AbstractList<Integer> {
        final int[] data;
        final int offset, size;        

        IntList(final int[] data, final int offset, final int size) {
            this.data = data;
            this.offset = offset;
            this.size = size;
        }

        @Override
        public Integer get(final int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
            return data[index + offset];
        }

        @Override
        public int size() {
            return size;
        }
    }

Solution-II(T:O(n), S:O(1))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        while (left <= right) {
            ans.add(arr[left]);
            left++;
        }

        return ans;
    }
}
  
