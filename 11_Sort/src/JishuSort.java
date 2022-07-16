public class JishuSort {

    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }

        int index = 0;
        for (int i = min; i <= max; i++) {
            while (counts[i - min] > 0) {
                nums[index++] = i;
                counts[i - min]--;
            }

        }
        return nums;
    }
}
