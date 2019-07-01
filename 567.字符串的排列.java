/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 *
 * https://leetcode-cn.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (32.04%)
 * Likes:    56
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 19.2K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 示例1:
 * 
 * 
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 
 * 
 * 
 * 
 * 示例2:
 * 
 * 
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * 
 * 
 */
//注意这里的前期边界条件的判定，s1 必须小于s2
//第一次写的时候在这里有失误
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] l1 = new int[26];
        int[] l2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            l1[s1.charAt(i) - 'a']++;
            l2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (isSame(l1, l2)) {
                return true;
            }
            // l2[s2.charAt(i) - 'a']++;
            l2[s2.charAt(i - s1.length()) - 'a']--;
            l2[s2.charAt(i) - 'a']++;
        }

        return isSame(l1, l2);

    }

    public boolean isSame(int[] l1, int[] l2) {
        for (int i = 0; i < 26; i++) {
            if (l1[i] != l2[i]) {
                return false;
            }
        }
        return true;
    }
}
