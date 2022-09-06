package dencka.kim.easy.tree;

class NodeDepths {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.left = new BinaryTree(2);
        bt.right = new BinaryTree(3);
        bt.left.left = new BinaryTree(4);
        bt.left.right = new BinaryTree(5);
        bt.right.left = new BinaryTree(6);
        bt.right.right = new BinaryTree(7);
        bt.left.left.left = new BinaryTree(8);
        bt.left.left.right = new BinaryTree(9);

        System.out.println(nodeDepths(bt));
    }

    static int result;

    public static int nodeDepths(BinaryTree root) {
        result = 0;
        countDepth(root, 0);
        return result;
    }

    public static void countDepth(BinaryTree tree, int cnt) {
        result += cnt;
        if (tree.left != null) countDepth(tree.left, cnt + 1);
        if (tree.right != null) countDepth(tree.right, cnt + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
