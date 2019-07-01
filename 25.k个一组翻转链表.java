/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] k个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (50.44%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    13.2K
 * Total Submissions: 25.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int nodeLength = 0;
        ListNode node = head;
        while (node != null) {
            ++nodeLength;
            node = node.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        // ListNode preNode = pre;
        ListNode preSubListHead = pre;
        // ListNode tail = null;
        while (nodeLength >= k) {

            ListNode tail = head;
            for (int i = 1; i < k; i++) {
                tail = tail.next;// 计算子链表的尾节点
            }

            ListNode tailHead = tail.next;// 下一子链表的头节点
            tail.next = null;// 分割链表

            preSubListHead.next = reversListNode(head);// 反转该部分子链表
            head.next = tailHead;// 连接翻转后的子链表与未翻转部分
            preSubListHead = head;// 移动到未翻转链表表头的前一位置
            head = tailHead;// 指向下一链表表头

            nodeLength -= k;

        }
        return pre.next;

    }

    private ListNode reversListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode = reversListNode(head.next);
        head.next.next = head;
        head.next = null;
        return tempNode;
    }

}
