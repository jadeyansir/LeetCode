/**
 * 121. 买卖股票的最佳时机
 *
 * @author yan
 * @date 2022/7/3
 */
public class Array_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null) {
                return 0;
            }
            //存放结果
            int result = 0;
            //记录最低价格
            int minPriceI = prices[0];
            for (int i = 1; i < prices.length; i++) {
                //当前价格与历史最低价格差值
                int temp = prices[i] - minPriceI;
                //小于0说明当前价格比历史最低价格还低
                if (temp < 0) {
                    //置换最低价格
                    minPriceI = prices[i];
                    continue;
                }
                //比较当前价格到历史最低价格，，，与历史最高价到最低价差值
                result = Math.max(temp, result);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(new Array_121().new Solution().maxProfit(ints));
    }
}
