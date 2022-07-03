package leetcode75.level1.day6;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 */

public class BinaryTreeLevelOrderTraversal {

    private final List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return output;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        process(queue);
        return output;

    }

    private void process(List<TreeNode> currentQueue) {
        if(currentQueue.isEmpty()) return;
        List<Integer> levels = new ArrayList<>();
        List<TreeNode> nextQueue = new ArrayList<>();
        for(TreeNode current:currentQueue) {
            levels.add(current.val);
            if(current.left!=null) nextQueue.add(current.left);
            if(current.right!=null) nextQueue.add(current.right);
        }
        output.add(levels);
        process(nextQueue);
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
