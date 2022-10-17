package dencka.kim.medium.binary_search_trees;

class ValidateBST {
    public static boolean validateBst(BST tree) {
        return helper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(BST tree, int min, int max) {
        if (tree == null) return true;
        if (tree.value < min || tree.value >= max) return false;
        boolean leftIsValid = helper(tree.left, min, tree.value);
        return leftIsValid && helper(tree.right, tree.value, max);
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
