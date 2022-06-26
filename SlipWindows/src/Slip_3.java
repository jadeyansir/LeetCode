import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @author yan
 * @date 2022/6/24
 */
public class Slip_3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    start = Math.max(map.get(c) + 1, start);
                }
                length = Math.max(i - start + 1, length);
                map.put(c, i);
            }
            return length;
        }
    }

    public static void main(String[] args) {
        String s = "abcbca";
        System.out.println(new Slip_3().new Solution().lengthOfLongestSubstring(s));
    }
}
