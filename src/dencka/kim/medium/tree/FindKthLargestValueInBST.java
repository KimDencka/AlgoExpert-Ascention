package dencka.kim.medium.tree;

import java.util.*;

class FindKthLargestValueInBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findKthLargestValueInBst(BST tree, int k) {
        Stack<BST> list = new Stack<>();
        while (true) {
            while (tree != null) {
                list.push(tree);
                tree = tree.right;
            }
            tree = list.pop();
            if (--k == 0) return tree.value;
            tree = tree.left;
        }
    }
}