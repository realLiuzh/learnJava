import java.util.Arrays;

/**
 * 如何将数据插入到有序数组中
 * 时间复杂度O(lgn)
 */
public class InsertBySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,7,10,10,10,16,45,47,57,68,798};
        System.out.println(Arrays.toString(nums));
        nums = insertBySearch(nums, 10);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] insertBySearch(int[] nums, int target) {
        // 找到要插入的位置
        int index = findTargetIndex(nums, target);

        int[] newNums = new int[nums.length + 1];
        newNums[index] = target;
        for (int i = 0; i < newNums.length; i++) {
            if (i < index) {
                newNums[i] = nums[i];
            } else if (i > index) {
                newNums[i] = nums[i-1];
            }
        }

        return newNums;
    }

    private static int findTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
