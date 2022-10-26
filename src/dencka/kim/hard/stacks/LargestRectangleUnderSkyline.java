package dencka.kim.hard.stacks;

import java.util.*;

class LargestRectangleUnderSkyline {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2));
        System.out.println(largestRectangleUnderSkyline(input));
    }

    public static int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        int result = 0;
        Stack<Integer> pillarsIdx = new Stack<>();
        buildings.add(0);
        for (int i = 0; i < buildings.size(); i++) {
            int height = buildings.get(i);
            while (!pillarsIdx.isEmpty() && buildings.get(pillarsIdx.peek()) >= height) {
                int pillarHeight = buildings.get(pillarsIdx.pop());
                int width = (pillarsIdx.isEmpty()) ? i : i - pillarsIdx.peek() - 1;
                result = Math.max(width * pillarHeight, result);
            }
            pillarsIdx.push(i);
        }
        return result;
    }
}
