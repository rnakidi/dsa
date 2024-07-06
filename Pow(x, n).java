50. Pow(x, n)
Description
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

Solution(T:O(logn), S:O(1))
We will opt for Binary Exponentiation using which we can calculate xn using O log2(N) multiplications.
Basic Idea is to divide the work using binary representation of exponents
i.e. is to keep multiplying pow with x, if the bit is odd, and multiplying x with itself until we get 0
We will use very 1st example of 1st Approach i.e.
x = 7, n = 11 and pow = 1
Here, we have to calculate 7^11
Binary of n i.e. (11)10 is (1011)2
1   0   1   1
2^3  2^2  2^1  2^0   <-- Corresponding place values of each bit

OR we can also write this as
1 0 1 1
8 4 2 1 <-- Corresponding place values of each bit

Now, 7^8 × 7^2 × 7^1 == 7^11 as 7^(8 + 2 + 1) == 7^11
NOTE: We have not considered 74 in this case as the 4th place bit is OFF

So, 7^8 × 7^2 × 7^1 == 5764801 × 49 × 7 == 1977326743 <-- Desired Output
Now, applying logic keeping this concept in mind.
PROCESS

Iteration 1
pow = 1 × 7 = 7
x = 7 × 7 = 49
n = 11 >>> 1 = 5

Iteration 2
pow = 7 × 49 = 343
x = 49 × 49 = 2401
n = 5 >>> 1 = 2

Iteration 3
x = 2401 × 2401 = 5764801
n = 2 >>> 1 = 1

Iteration 4
pow = 343 × 5764801 = 1977326743
x = 5764801 × 5764801 = 3.323293057 × 10¹³
n = 1 >>> 1 = 0

We exit the loop as the number has become 0 and we got pow as 1977326743 which is the desired output
In this binary exponentiation approach, the loop iterated for only 4 times which is nothing but (O log2(N) + 1) ~ (O log2(N))

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        double pow = 1;
        while (n != 0) {
            if ((n&1) != 0) { // means odd, multiply 'x' with 'pow'
                pow *= x;
            }

            x *= x;
            n >>>= 1;
        }
        return pow;
    }
}
