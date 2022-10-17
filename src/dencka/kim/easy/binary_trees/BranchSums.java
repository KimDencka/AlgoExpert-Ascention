package dencka.kim.easy.binary_trees;

import java.util.*;

class BranchSums {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.left = new BinaryTree(2);
        bt.left.left = new BinaryTree(4);
        bt.left.right = new BinaryTree(5);
        bt.left.left.left = new BinaryTree(8);
        bt.left.left.right = new BinaryTree(9);
        bt.left.right.left = new BinaryTree(10);
        bt.right = new BinaryTree(3);
        bt.right.left = new BinaryTree(6);
        bt.right.right = new BinaryTree(7);

        System.out.println(branchSums(bt));
    }

    public static List<Integer> branchSums(BinaryTree root) {
        LinkedList<Integer> ll = new LinkedList<>();
        return count(root, ll, 0);

    }

    public static LinkedList<Integer> count(BinaryTree tree, LinkedList<Integer> list, int cnt) {
        if (tree.left == null && tree.right == null) {
            list.add(cnt + tree.value);
        } else if (tree.left != null && tree.right == null) {
            count(tree.left, list, cnt + tree.value);
        } else if (tree.left == null) {
            count(tree.right, list, cnt + tree.value);
        } else {
            count(tree.left, list, cnt + tree.value);
            count(tree.right, list, cnt + tree.value);
        }
        return list;
    }


    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
