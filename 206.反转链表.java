/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (59.91%)
 * Likes:    460
 * Dislikes: 0
 * Total Accepted:    66.7K
 * Total Submissions: 107K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
// 迭代，注意边界条件，第一次做的时候不对，迭代较为简单

class Solution {
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return pre;
    }
}

// 递归，递归分析问题时可以画图辅助整理思路

class Solution {
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tempNode;

    }
}
