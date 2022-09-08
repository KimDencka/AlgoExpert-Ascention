package dencka.kim.medium.collection;

class MonotonicArray {
    public static void main(String[] args) {
        int[] input = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        System.out.println(isMonotonic(input));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0) return true;
        boolean isDecreasing = array[0] > array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            if (isDecreasing && array[i] > array[i - 1]) return false;
            if (!isDecreasing && array[i] < array[i - 1]) return false;
        }
        return true;
    }

    // the same solution (long version)
//    public static boolean isMonotonic(int[] array) {
//        if (array.length == 0) return true;
//        if (array[0] > array[array.length - 1]) {
//            for (int i = 0; i < array.length - 1; i++)
//                if (array[i] < array[i + 1])
//                    return false;
//        } else {
//            for (int i = 0; i < array.length - 1; i++)
//                if (array[i] > array[i + 1])
//                    return false;
//        }
//        return true;
//    }
}
