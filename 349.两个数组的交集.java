import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (61.50%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    23.6K
 * Total Submissions: 37K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */
//由于给的数据可能是重复的，我们先转成set
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) {
            set2.add(n);
        }

        /***
         * 调用内置函数
         * 
         * set1.retainAll(set2);
         * 
         * int[] output = new int[set1.size()]; int index = 0; for (Integer var : set1)
         * { output[index++] = var; } return output;
         * 
         */
        // 使用迭代的思路，检查1集合中的数字是否在2集合中
        int[] output = new int[set1.size()];
        int index = 0;
        for (Integer var : set1) {
            if (set2.contains(var)) {
                output[index++] = var;
            }
        }
        return Arrays.copyOf(output, index);

    }
}
