package leetcode75.level1.day6;

/*
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreOrderTraversal {

    public static void main(String[] args) {
        //Output: [1,3,5,6,2,4]
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _2 = new Node(2);
        Node _4 = new Node(4);

        List<Node> children = new ArrayList<>();
        children.add(_5);
        children.add(_6);

        Node _3 = new Node(3, children);

        List<Node> children_2 = new ArrayList<>();
        children_2.add(_3);
        children_2.add(_2);
        children_2.add(_4);

        Node _1 = new Node(1, children_2);

        NaryTreePreOrderTraversal traversal = new NaryTreePreOrderTraversal();
        System.out.println(traversal.preorder(_1));


    }

    //Intentionally implemented an iterative solution. Used a queue as a stack for Depth first traversal.
    public List<Integer> preorder(Node root) {

        if (root == null) return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        List<Node> stack = new ArrayList<>();
        stack.add(root);
        int i = 0;
        do {
            Node current = stack.get(i);
            stack.remove(i);
            output.add(current.val);
            stack.addAll(addChildren(current));
            i = stack.size() - 1;
        } while (i >= 0);


        return output;
    }

    private List<Node> addChildren(Node node) {
        List<Node> children = new ArrayList<>();
        if (node.children != null && !node.children.isEmpty()) {
            for (int i = node.children.size() - 1; i >= 0; i--) {
                children.add(node.children.get(i));
            }
        }
        return children;
    }

}

//Node definition from Leetcode


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
