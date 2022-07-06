/**
 * 33. 搜索旋转排序数组
 *
 * @author yan
 * @date 2022/7/4
 */
public class Array_33 {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 1 && target == nums[0]) {
                return 0;
            }
            int right = nums.length - 1;
            int left = 0;
            while (left < right) {
                //防止大数溢出
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] < nums[mid]) {
                    if (nums[mid] > target && nums[left] < target) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                } else {
                    if (nums[mid] < target && nums[right] > target) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    // 67812345

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Array_33().new Solution().search(ints, 0));
    }
}
