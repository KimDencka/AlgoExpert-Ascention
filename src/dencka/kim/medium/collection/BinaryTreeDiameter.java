package dencka.kim.medium.collection;

class BinaryTreeDiameter {
    int diameter;

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        getDiameter(tree);
        return diameter;
    }

    public int getDiameter(BinaryTree tree) {
        int leftCnt = 0;
        int rightCnt = 0;
        if (tree.left == null && tree.right == null) return 0;
        if (tree.left != null) leftCnt = getDiameter(tree.left) + 1;
        if (tree.right != null) rightCnt = getDiameter(tree.right) + 1;
        diameter = Math.max(leftCnt + rightCnt, diameter);
        return Math.max(leftCnt, rightCnt);
    }
}
