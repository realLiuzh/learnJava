import java.util.Arrays;

public class GuibingSort {
    public static void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int leftIndex = left, rightIndex = mid + 1, index = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[index++] = nums[leftIndex++];
            } else {
                temp[index++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[index++] = nums[rightIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i + left] = temp[i];
        }

    }

    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
