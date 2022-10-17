package dencka.kim.medium.binary_search_trees;

class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            insertHelper(this, value);
            return this;
        }

        public  BST insertHelper(BST tree, int value) {
            if (tree == null) return new BST(value);
            if (value < tree.value) tree.left = insertHelper(tree.left, value);
            else tree.right = insertHelper(tree.right, value);
            return tree;
        }

        public boolean contains(int value) {
            return containsHelper(this, value);
        }

        public boolean containsHelper(BST tree, int value) {
            if (tree == null) return false;
            if (tree.value == value) return true;
            else if (value < tree.value) return containsHelper(tree.left, value);
            else return containsHelper(tree.right, value);
        }

        public BST remove(int value) {
            removeHelper(this, value);
            return this;
        }

        public BST removeHelper(BST tree, int value) {
            if (tree == null) return null;
            if (value < tree.value) tree.left = removeHelper(tree.left, value);
            else if (value > tree.value) tree.right = removeHelper(tree.right, value);
            else {
                if (tree.left == null && tree.right == null) return null;
                if (tree.left != null && tree.right == null) {
                    tree.value = tree.left.value;
                    tree.right = tree.left.right;
                    tree.left = tree.left.left;
                    return tree;
                }
                if (tree.left == null) {
                    tree.value = tree.right.value;
                    tree.left = tree.right.left;
                    tree.right = tree.right.right;
                    return tree;
                }
                if (tree.left != null && tree.right != null) {
                    int minValue = getMinValue(tree.right);
                    tree.value = minValue;
                    tree.right = removeHelper(tree.right, minValue);
                    return tree;
                }

            }
            return tree;
        }

        public int getMinValue(BST binaryTree) {
            return binaryTree.left == null ? binaryTree.value : getMinValue(binaryTree.left);
        }
    }
}
