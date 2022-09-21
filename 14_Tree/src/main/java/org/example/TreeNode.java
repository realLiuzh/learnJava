package org.example;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
     TreeNode left;
     TreeNode right;
     int val;

    TreeNode(int x) {
        this.val = x;
    }

    // 前序遍历
//    public

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, LinkedList<Integer> nodes) {
        if (root != null) {
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right, nodes);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null && !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && prev != cur.right) {
                cur = cur.right;
            } else {
                stack.pop();
                nodes.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return nodes;
    }

}
