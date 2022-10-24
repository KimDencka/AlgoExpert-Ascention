package dencka.kim.hard.dynamic_programming;

class WaterArea {
    // time: O(n), space: O(1)
    public static int waterArea(int[] heights) {
        if (heights.length == 0) return 0;
        int l = 0, r = heights.length - 1;
        int leftMax = heights[l];
        int rightMax = heights[r];
        int result = 0;
        while (l < r) {
            if (heights[l] < heights[r]) {
                l++;
                leftMax = Math.max(heights[l], leftMax);
                result += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(heights[r], rightMax);
                result += rightMax - heights[r];
            }
        }
        return result;
    }

    // time: O(n), space: O(n)
//    public static int waterArea(int[] heights) {
//        if (heights.length == 0) return 0;
//        int n = heights.length;
//        int result = 0;
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//        leftMax[0] = heights[0];
//        rightMax[n - 1] = heights[n - 1];
//        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
//        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
//        for (int i = 0; i < n; i++) result += Math.min(leftMax[i], rightMax[i]) - heights[i];
//        return result;
//    }
}
