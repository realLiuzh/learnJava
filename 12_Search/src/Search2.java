public class Search2 {

    public int search(int[] nums, int target) {
        int leaf = 0;
        int right = nums.length - 1;
        while (leaf <= right) {
            int mid = (leaf + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                leaf = mid + 1;
            }
        }
        return -1;


    }


}
