package dencka.kim.medium.tree;

import java.util.*;

class ReconstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        Stack<BST> stack = new Stack<>();
        int cnt = 0;
        BST head = new BST(preOrderTraversalValues.get(cnt));
        BST curr = head;
        stack.push(curr);
        cnt++;
        while (cnt < preOrderTraversalValues.size()) {
            if (curr.value > preOrderTraversalValues.get(cnt)) {
                BST node = new BST(preOrderTraversalValues.get(cnt));
                stack.push(node);
                curr.left = node;
                curr = curr.left;
            } else {
                while (!stack.isEmpty() && preOrderTraversalValues.get(cnt) >= stack.peek().value) {
                    curr = stack.pop();
                }
                BST node = new BST(preOrderTraversalValues.get(cnt));
                stack.push(node);
                curr.right = node;
                curr = curr.right;
            }
            cnt++;
        }
        return head;
    }
}
