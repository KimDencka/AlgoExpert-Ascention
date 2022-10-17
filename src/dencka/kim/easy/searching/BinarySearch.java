package dencka.kim.easy.searching;

class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};

        System.out.println(binarySearch(nums, 33));
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) return mid;

            if (array[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
