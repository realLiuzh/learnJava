public class Search {

    // 二分查找
    // target为要查询的目标值
    // nums为排序数组
    public int search(int[] nums, int target) {
        // 创建左右两个指针
        int left = 0;
        int right = nums.length - 1;
        // 左右指针在合法的范围内，就还有机会
        // 这样一次一次的缩小查询范围
        while (left <= right) {
            // 找到中间值
            int mid = (left + right) / 2;
            // 找到直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 中间值大于目标值，那么中间值右边的值也大于目标值。right=mid-1
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 中间值小于目标值，那么中间值左侧的值也小于目标值，left=mid+1
                left = mid + 1;
            }
        }
        return -1;
    }
}
