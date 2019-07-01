/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (35.35%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    40.4K
 * Total Submissions: 111.6K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */
//应该想到二分查找,记住二分查找的边界条件
//注意练习第35题，返回left，right的异同
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return right;
    }
}
