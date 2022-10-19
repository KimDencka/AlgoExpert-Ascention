package dencka.kim.medium.stacks;

import java.util.*;

class NextGreaterElement {
    public static void main(String[] args) {
        int[] input = new int[]{2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(nextGreaterElement(input)));
    }

    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < 2 * array.length; i++) {
            int idx = i % array.length;
            while (!indices.isEmpty() && array[indices.peek()] < array[idx]) {
                int front = indices.pop();
                result[front] = array[idx];
            }
            indices.push(idx);
        }
        return result;
    }
}
