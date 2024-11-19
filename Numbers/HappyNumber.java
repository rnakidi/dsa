202. Happy Number - https://leetcode.com/problems/happy-number/description/ - EASY

class Solution {
    public boolean isHappy(int n) {
        int slow = n ; 
        int fast = n ; 
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    private int square(int n){
        int ans = 0;
        while(n>0){
            int rem = n%10;
            ans+=rem*rem;
            n/=10;
        }
        return ans;
    }
}

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (visited.add(n)) {
            n = getNextNumber(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int getNextNumber(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            output += (digit * digit);
            n = n / 10;
        }

        return output;
    }
}
