import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * nums[i] == nums[i - 1]无法实现去重，，，往后比较可能会造成一次都无法遍历，比如0 0 0 0
 * 如果往前比较就不会出现这个情况，，，所以以后数组去除相同的数据时尽量和前一个比较
 *
 * @author yan
 * @date 2022/7/1
 */
public class Array_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();
            //特殊情况处理
            if (nums == null || nums.length < 3) {
                return resultList;
            }
            Arrays.sort(nums);
            if (nums[0] > 0) {
                return resultList;
            }
            for (int i = 0; i < nums.length; i++) {
                //如果当前数据大于0，，，那么他之后的数据一定都大于0
                if (nums[i] > 0) {
                    break;
                }
                //nums[i] == nums[i + 1]无法实现去重，，，往后比较可能会造成一次都无法遍历，比如0 0 0 0
                //如果往前比较就不会出现这个情况，，，所以以后数组去除相同的数据时尽量和前一个比较
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int temp = nums[i] + nums[left] + nums[right];
                    //处理为0，，，去重
                    if (temp == 0) {
                        resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //左右移动
                        left++;
                        right--;
                    }
                    //大于0左移，，，比0大 说明右边的数据太大了，，，需要右边往左移
                    if (temp > 0) {
                        right--;
                    }
                    //小于0右移
                    if (temp < 0) {
                        left++;
                    }
                }
            }
            return resultList;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, -1, -1, 0};
        System.out.println(new Array_15().new Solution().threeSum(ints));
    }
}
