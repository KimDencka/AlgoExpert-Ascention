package dencka.kim.medium.graphs;

class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        AncestralTree t1 = descendantOne;
        AncestralTree t2 = descendantTwo;
        int depth1 = getDepth(t1, topAncestor);
        int depth2 = getDepth(t2, topAncestor);
        if (depth2 > depth1) {
            return iterate(t1, t2, depth2 - depth1);
        } else {
            return iterate(t2, t1, depth1 - depth2);
        }
    }

    public static AncestralTree iterate(AncestralTree tree1, AncestralTree tree2, int depth) {
        // if (depth2 > depth1
        while (depth != 0) {
            tree2 = tree2.ancestor;
            depth--;
        }
        if (tree2 == tree1) {
            return tree2;
        } else {
            while (tree1 != tree2) {
                tree1 = tree1.ancestor;
                tree2 = tree2.ancestor;
            }
        }
        return tree1;
    }

    public static int getDepth(AncestralTree tree, AncestralTree top) {
        int depth = 0;
        while (tree != top) {
            tree = tree.ancestor;
            depth++;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
