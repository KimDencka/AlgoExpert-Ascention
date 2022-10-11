package dencka.kim.medium.tree;

import java.util.*;

class BSTTraversal {
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

class Runner {
    public static void main(String[] args) {
        BSTTraversal.BST tree = new BSTTraversal.BST(10);
        tree.right = new BSTTraversal.BST(12);
        tree.left = new BSTTraversal.BST(8);
        tree.right.right = new BSTTraversal.BST(14);
        tree.right.left = new BSTTraversal.BST(13);
        tree.left.right = new BSTTraversal.BST(9);
        tree.left.left = new BSTTraversal.BST(7);

        System.out.println((BSTTraversal.inOrderTraverse(tree, new ArrayList<>())));     // [7, 8, 9, 10, 13, 12, 14]
        System.out.println((BSTTraversal.preOrderTraverse(tree, new ArrayList<>())));    // [10, 8, 7, 9, 12, 13, 14]
        System.out.println((BSTTraversal.postOrderTraverse(tree, new ArrayList<>())));   // [7, 9, 8, 13, 14, 12, 10]
    }
    //             10
    //           /    \
    //         8        12
    //       /   \    /    \
    //     7      9  13     14
}
