package dencka.kim.medium.greedy_algorithms;

class ValidStartingCity {
    public static void main(String[] args) {
        int[] distances = new int[]{5, 25, 15, 10, 15};
        int[] fuel = new int[]{1, 2, 1, 0, 3};
        int mpg = 10;
        System.out.println(validStartingCity(distances, fuel, mpg));
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int lack = 0, startCity = 0, remains = 0;
        for (int start = 1; start < distances.length; start++) {
            remains += (mpg * fuel[start - 1]) - distances[start - 1];
            if (remains < lack) {
                startCity = start;
                lack = remains;
            }
        }
        return startCity;
    }
}
