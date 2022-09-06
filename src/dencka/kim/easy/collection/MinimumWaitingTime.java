package dencka.kim.easy.collection;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(nums));
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < queries.length - 1; i++) {
            sum += queries[i];
            result += sum;
        }
        return result;
    }

    //KIM_INFO FROM SOLUTIONS
//    public int minimumWaitingTime(int[] queries) {
//        Arrays.sort(queries);
//        int totalWaitingTime = 0;
//        int cnt = 0;
//        for (int i = 0; i < queries.length; i++) {
//            cnt++;
//            totalWaitingTime += queries[i] * (queries.length - cnt);
//        }
//        return totalWaitingTime;
//    }
}
