import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author yan
 * @date 2022/8/1
 */
public class Array_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            int[] dxs = {0, 1, 0, -1};
            int[] dys = {1, 0, -1, 0};
            int x = 0, y = 0, temp = 0;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m * n; i++) {
                ans.add(matrix[x][y]);
                matrix[x][y] = 101;
                int dx = x + dxs[temp];
                int dy = y + dys[temp];
                if (dx < 0 || dy < 0 || dx > m || dy > n || matrix[dx][dy] == 101) {
                    temp = (temp + 1) % 4;
                }
                x = x + dxs[temp];
                y = y + dys[temp];
            }
            return ans;
        }
    }
}
