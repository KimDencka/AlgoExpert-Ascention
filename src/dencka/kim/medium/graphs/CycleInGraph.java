package dencka.kim.medium.graphs;

public class CycleInGraph {
    public static void main(String[] args) {
        int[][] input =
                new int[][]{
                        {1, 3},
                        {2, 3, 4},
                        {0},
                        {},
                        {2, 5},
                        {}
                };
        System.out.println(cycleInGraph(input));
    }

    public static boolean cycleInGraph(int[][] edges) {
        int numberOfNode = edges.length;
        boolean[] seen = new boolean[numberOfNode];
        boolean[] currentlyInStack = new boolean[numberOfNode];
        for (int node = 0; node < numberOfNode; node++) {
            if (seen[node]) continue;
            boolean containsCycle = isNodeInCycle(node, edges, seen, currentlyInStack);
            if (containsCycle) return true;
        }
        return false;
    }

    public static boolean isNodeInCycle(int node, int[][] edges, boolean[] seen, boolean[] currentlyInStack) {
        seen[node] = true;
        currentlyInStack[node] = true;
        int[] neighbours = edges[node];
        boolean containsCycle = false;
        for (int neighbour : neighbours) {
            if (!seen[neighbour]) {
                containsCycle = isNodeInCycle(neighbour, edges, seen, currentlyInStack);
            }
            if (containsCycle || currentlyInStack[neighbour]) return true;
        }
        currentlyInStack[node] = false;
        return false;
    }


}
