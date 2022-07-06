/**
 * 53. 最大子数组和
 *
 * @author yan
 * @date 2022/7/2
 */
public class Array_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            //作为起始点
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //从起始点到当前点的数据之和，，，如果加入本点比本点小，取本点
                temp = Math.max(temp + nums[i], nums[i]);
                max = Math.max(max, temp);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 4, -1, 7, 8};
        System.out.println(new Array_53().new Solution().maxSubArray(ints));
    }
}
