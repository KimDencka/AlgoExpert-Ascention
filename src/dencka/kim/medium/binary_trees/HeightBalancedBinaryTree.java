package dencka.kim.medium.binary_trees;

class HeightBalancedBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        int left = getHeight(tree.left);
        int right = getHeight(tree.right);
        return Math.abs(left - right) <= 1;
    }

    public int getHeight(BinaryTree tree) {
        if (tree == null) return 0;
        int left = getHeight(tree.left);
        int right = getHeight(tree.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
