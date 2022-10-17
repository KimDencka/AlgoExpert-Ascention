package dencka.kim.medium.dynamic_programming;

class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(10, new int[]{1, 5, 10, 25}));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int num : denoms) {
            for (int j = 0; j < ways.length; j++) {
                if (num <= j) ways[j] += ways[j - num];
            }
        }
        return ways[n];
    }
}
