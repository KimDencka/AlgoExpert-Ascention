package dencka.kim.medium.famous_algorithms;

class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : array) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
