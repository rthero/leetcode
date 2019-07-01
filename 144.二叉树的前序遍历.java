/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode p = s.pop();
            if (p != null) {
                l.add(p.val);
                if (p.right != null) {
                    s.push(p.right);
                }
                if (p.left != null) {
                    s.push(p.left);
                }
            }
        }
        return l;
    }
}
