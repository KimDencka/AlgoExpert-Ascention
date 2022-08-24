package dencka.kim.easy.tree;

public class FindClosestValueInBST {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.right = new BST(15);
        bst.left.left = new BST(2);
        bst.left.right = new BST(5);
        bst.left.left.left = new BST(1);
        bst.right.left = new BST(13);
        bst.right.left.right = new BST(14);
        bst.right.right = new BST(22);

        System.out.println(findClosestValueInBst(bst, 12));
    }

    public static int findClosestValueInBst(BST tree, int target) {
        int closestValue = 0;
        int diff = Integer.MAX_VALUE;

        while (tree != null) {
            int curDiff = Math.abs(tree.value - target);
            if (curDiff < diff) {
                diff = curDiff;
                closestValue = tree.value;
            }

            if (tree.value == target) {
                return tree.value;
            } else if (target > tree.value) {
                tree = tree.right;
            } else {
                tree = tree.left;
            }
        }
        return closestValue;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        {
            left = null;
            right = null;
        }

        public BST(int value) {
            this.value = value;
        }
    }
}
