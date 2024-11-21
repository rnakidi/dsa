67. Add Binary - https://leetcode.com/problems/add-binary/description/ - EASY

class Solution {
    public String addBinary(String a, String b) {
        int aNum = Integer.parseInt(a, 2);
        int bNum = Integer.parseInt(b, 2);
        return Integer.toBinaryString(aNum + bNum);
    }
}
