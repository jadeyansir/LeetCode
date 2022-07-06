import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author yan
 * @date 2022/7/3
 */
public class Array_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    return new int[]{map.get(temp), i};
                }
                map.put(nums[i], i);
            }
            return new int[2];
        }
    }
}
