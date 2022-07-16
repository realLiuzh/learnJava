public class GuibingSort2 {
    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right) >> 1;

            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);

            merge(nums, left, middle, right);
        }

    }

    private void merge(int[] nums, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int leftIndex = left, rightIndex = middle + 1, index = 0;
        while (leftIndex <= middle && rightIndex <= right) {

            if (nums[leftIndex] < nums[rightIndex]) {
                temp[index++] = nums[leftIndex++];
            } else {
                temp[index++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            temp[index++] = nums[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[index++] = nums[rightIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[left+i]=temp[i];
        }

    }
}
