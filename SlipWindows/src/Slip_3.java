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
            //设置map存放字符和字符所在下标
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                //如果出现重复字符
                if (map.containsKey(c)) {
                    //记录最大长度，，，并将起始点设置为前一个重复字符所在下标+1
                    //比如abcabcbb    当探寻到第二个a是要讲初始位置设置为第一个b
                    //这样所包含范围内均是不同字符
                    start = Math.max(map.get(c) + 1, start);
                }
                //不是重复字符，记录长度：
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
