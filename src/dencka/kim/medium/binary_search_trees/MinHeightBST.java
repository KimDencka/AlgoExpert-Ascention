package dencka.kim.medium.binary_search_trees;

import java.util.*;

class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        int low = 0, high = array.size() - 1;
        int mid = low + (high - low) / 2;
        BST bst = new BST(array.get(mid));
        build(bst, array, low, mid - 1);
        build(bst, array, mid + 1, high);
        return bst;
    }

    public static void build(BST tree, List<Integer> array, int low, int high) {
        if (low > high) return;
        int mid = low + (high - low) / 2;
        tree.insert(array.get(mid));
        build(tree, array, low, mid - 1);
        build(tree, array, mid + 1, high);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MinHeightBST.BST tree = MinHeightBST.minHeightBst(List.of(1, 2, 5, 7, 10, 13, 14, 15, 22));
        System.out.println(preOrderTraverse(tree, new ArrayList<>())); // PreOrder: [10, 2, 1, 5, 7, 14, 13, 15, 22]
    }

    public static List<Integer> preOrderTraverse(MinHeightBST.BST tree, List<Integer> array) {
        if (tree == null) return array;
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }
}
