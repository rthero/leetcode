/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
//一是考虑到特殊情况，负数和结尾为零的数
//二是 边界情况：0，小于10的数，给的数是偶数位还是奇数位
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;

        }
        if (x == revertedNum || x == (revertedNum / 10)) {
            return true;
        }
        return false;

    }
}
