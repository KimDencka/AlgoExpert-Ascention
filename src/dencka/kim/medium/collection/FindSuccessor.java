package dencka.kim.medium.collection;

import java.util.*;

class FindSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    // time: O(h), space: O(1); h - height
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) return getLeftmostChild(node.right);
        return getRightmostParent(node);
    }

    public BinaryTree getLeftmostChild(BinaryTree node) {
        BinaryTree curr = node;
        while (curr.left != null) curr = curr.left;
        return curr;
    }

    public BinaryTree getRightmostParent(BinaryTree node) {
        BinaryTree curr = node;
        while (curr.parent != null && curr.parent.right == curr) {
            curr = curr.parent;
        }
        return curr.parent;
    }


    // time: O(n), space: O(n); n - number of elements
//    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
//        ArrayList<BinaryTree> arr = new ArrayList<>();
//        inorderTraversal(tree, arr);
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i) != node) continue;
//            if (i == arr.size() - 1) break;
//            return arr.get(i + 1);
//        }
//        return null;
//    }
//
//    public void inorderTraversal(BinaryTree tree, List<BinaryTree> array) {
//        if (tree == null) return;
//        inorderTraversal(tree.left, array);
//        array.add(tree);
//        inorderTraversal(tree.right, array);
//    }
}
