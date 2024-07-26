204. Count Primes
Description
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  
Example 2:
Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0 

Constraints:

0 <= n <= 5 * 106

Solution(T:O(n*logn), S:O(1))
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int p = 2;  p < n; p++) {
            boolean flag = true;
             for (int f = 2; f <= p/2; f++) {
               if (p%f == 0) {
                    flag = false;
                    break;
               }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}

Solution(T:O(sqrt(n)), S:O(1))
class Solution {
    public int countPrimes(int n) {
        if (0 == n || 1 == n) {
            return 0;
        }

        int[] primes = new int[n];
        primes[0] = 1;
        primes[1] = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) { // Math.sqrt can be repleced by Math.pow(n, 0.5) or i * i
            if (primes[i] == 0) {
                int j = i * 2; // mark multiples of i
                while (j < n) {
                    primes[j] = 1;
                    j += i;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i] == 0) {
                ans++;            }
        }

        return ans;
    }
}
