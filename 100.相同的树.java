/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;// 当根节点都为空时，可认为此时二子树相同
        }
        if (p != null && q != null && p.val == q.val) {// 当根节点值相同，且都有子树时，递归调用判断左右子树是否相同
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;// 当根节点的值不等，或者两个根节点一为空一不为空时，两树不等返回false
        }
        // 注意上两条注释中的根节点指的是当前环境下的子树，当递归调用后，传入的值仍可看作那时的当前环境的根节点
    }
}
