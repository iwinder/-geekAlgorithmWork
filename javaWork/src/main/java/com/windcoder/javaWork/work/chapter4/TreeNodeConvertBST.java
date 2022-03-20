package com.windcoder.javaWork.work.chapter4;

import com.windcoder.javaWork.common.TreeNode;

/**
 * [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)
 */
public class TreeNodeConvertBST {
    int sum = 0;

    /**
     * 反序中序遍历
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


    /**
     *  深度优先遍历
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int parentVal) {
        if (root == null)
            return parentVal;
        root.val += dfs(root.right, parentVal);
        return dfs(root.left, root.val);
    }
}
