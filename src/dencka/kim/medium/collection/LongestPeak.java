package dencka.kim.medium.collection;

class LongestPeak {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(input));
    }

    public static int longestPeak(int[] array) {
        int max = 0;
        boolean isPeak;
        for (int i = 1; i < array.length - 1; i++) {
            isPeak = array[i - 1] < array[i] && array[i + 1] < array[i];
            if (isPeak) {
                int left = i - 2;
                while (left >= 0 && array[left] < array[left + 1])
                    left--;

                int right = i + 2;
                while (right < array.length && array[right] < array[right - 1])
                    right++;
                int cur = right - left - 1;
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
