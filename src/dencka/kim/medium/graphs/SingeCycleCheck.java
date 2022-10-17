package dencka.kim.medium.graphs;

class SingeCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        int visited = 0;
        int curIdx = 0;
        while (visited < array.length) {
            if (visited > 0 && curIdx == 0) return false;
            visited++;
            curIdx = (array[curIdx] + curIdx) % array.length;
            curIdx = curIdx >= 0 ? curIdx : curIdx + array.length;
        }
        return curIdx == 0;
    }
}
