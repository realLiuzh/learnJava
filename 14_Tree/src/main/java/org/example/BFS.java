package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 广度搜索
public class BFS {
    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null) queue.offer(root);
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.setCharAt();
        List<Integer> result=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return result;

    }
}
