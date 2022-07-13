package leetcode75.level1.day8;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode _5 = new TreeNode(5);
        TreeNode _4 = new TreeNode(4);
        TreeNode _6 = new TreeNode(6);
        TreeNode _3 = new TreeNode(3);
        TreeNode _7 = new TreeNode(7);

        _5.left = _4;
        _5.right = _6;
        _6.left = _3;
        _6.right = _7;

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(_5));
        System.out.println(validateBinarySearchTree.nodes);
    }

    List<Integer> nodes = new ArrayList<>();


    //Inorder traversal (left, root, right) - incredibly slow with this implementation as we are traversing the whole tree to see if its valid.
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null) {
            isValidBST(root.left);
        }
        nodes.add(root.val);
        if(root.right!=null) {
            isValidBST(root.right);
        }
        for(int i=1;i<nodes.size();i++) {
            if(nodes.get(i) <= nodes.get(i-1)) return false;
        }
        return true;
    }

    //Neetcode implementation - https://www.youtube.com/watch?v=s6ATEkipzow

    public boolean isValidBST_neetcode(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long leftBoundary, long rightBoundary) {
        if(node==null) return true;
        return node.val < rightBoundary && node.val > leftBoundary && helper(node.left, leftBoundary, node.val) && helper(node.right, node.val, rightBoundary);
    }
}


//Implementation from Leetcode
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