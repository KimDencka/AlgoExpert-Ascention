package dencka.kim.medium.other;

class NumberOfWaysToTraverseGraph {
    public static void main(String[] args) {
        System.out.println((numberOfWaysToTraverseGraph(3, 4)));
    }

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) return 1;
        return numberOfWaysToTraverseGraph(width - 1, height)
                + numberOfWaysToTraverseGraph(width, height - 1);
    }
}
