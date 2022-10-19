package dencka.kim.medium.stacks;

import java.util.*;

class SortStack {
    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        System.out.println(sortStack(stack));
    }

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.isEmpty()) return stack;
        int top = stack.remove(stack.size() - 1);
        sortStack(stack);
        insert(stack, top);
        return stack;
    }

    public static void insert(ArrayList<Integer> stack, int value) {
        if (stack.isEmpty() || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        int top = stack.remove(stack.size() - 1);
        insert(stack, value);
        stack.add(top);
    }
}
