67. Add Binary - https://leetcode.com/problems/add-binary/description/ - EASY

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;
        int sum = 0;
        String output = "";
        while (lenA >= 0 || lenB >= 0 || carry != 0) { // carry == 1
            sum = carry;
            sum += lenA >= 0 ? (a.charAt(lenA--) - '0') : 0;
            sum += lenB >= 0 ? (b.charAt(lenB--) - '0') : 0;
            output = (sum%2) + output;
            carry = sum/2;
        }
        return output;
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int aNum = Integer.parseInt(a, 2);
        int bNum = Integer.parseInt(b, 2);
        return Integer.toBinaryString(aNum + bNum);
    }
}
