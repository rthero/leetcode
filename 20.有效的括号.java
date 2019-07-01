import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.30%)
 * Likes:    863
 * Dislikes: 0
 * Total Accepted:    85.4K
 * Total Submissions: 221.4K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
/**
 * 这是一种 类型题目，主要使用栈
 * 栈的作用：在表示问题的递归结构时，栈数据结构可以派上用场。我们无法真正地从内到外处理这个问题，因为我们对整体结构一无所知。但是，栈可以帮助我们递归地处理这种情况，即从外部到内部。
 * 
 * 
 * 其实开始的回文数应该也可以用栈来做
 * 
 * 
 * @param s
 * @return
 */

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        // 这里使用hashmap建立对应关系
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        for (Character ch : s.toCharArray()) {
            // 这里要注意思考如何保证两个对应括号中间夹杂其他括号的问题，通过判断逻辑来解决的时候可以从正反两个方向来解决
            if (!stack.empty() && ch == map.get(stack.peek()) && map.containsKey(stack.peek())) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
