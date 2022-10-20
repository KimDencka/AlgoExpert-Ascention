package dencka.kim.medium.recursion;

import java.util.*;

class StaircaseTraversal {

    public static void main(String[] args) {
        System.out.println(staircaseTraversal(8, 3));
    }

    // Sliding window
    public static int staircaseTraversal(int height, int maxSteps) {
        int ways = 0;
        List<Integer> waysToTop = new ArrayList<>();
        waysToTop.add(1);
        for (int curHeight = 1; curHeight < height + 1; curHeight++) {
            int l = curHeight - maxSteps - 1;
            int r = curHeight - 1;
            System.out.print(ways + " " + l + " " + r + " ");
            if (l >= 0) ways -= waysToTop.get(l);
            ways += waysToTop.get(r);
            waysToTop.add(ways);
            System.out.println(waysToTop);

        }
        return waysToTop.get(height);
    }

    // a little different
//    public static int staircaseTraversal(int height, int maxSteps) {
//        int cnt = 1;
//        List<Integer> ways = new ArrayList<>();
//        ways.add(1);
//        ways.add(1);
//        for (int i = 2; i <= maxSteps; i++) {
//            cnt *= 2;
//            ways.add(cnt);
//        }
//        for (int i = maxSteps + 1; i <= height; i++) {
//            cnt = cnt + ways.get(ways.size() - 1) - ways.remove(0);
//            ways.add(cnt);
//        }
//        return ways.get(ways.size() - 1);
//    }
}
