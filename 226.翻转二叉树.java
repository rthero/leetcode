/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
        // 以下注释的是另外一种方法，但是提交lettcode测试的结果表明，
        // 在时间复杂度和空间复杂度上都比上面第一种方法差，原因不明
        // TreeNode temp = invertTree(root.left);
        // root.left = invertTree(root.right)
        // root.right = temp;
        // return root;
    }
}
