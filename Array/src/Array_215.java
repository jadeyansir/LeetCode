/**
 * 215. 数组中的第K个最大元素
 *
 * @author yan
 * @date 2022/6/26
 */
public class Array_215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int tempArr[] = new int[k];
            //构造一个节点数为k的堆
            for (int i = 0; i < k; i++) {
                tempArr[i] = nums[i];
            }
            //调整堆   取（k-1）/ 2，，，参考完全二叉树，取最后一个节点的父节点
            for (int i = (k - 1) / 2; i >= 0; i--) {
                heapify(tempArr, k - 1, i);
            }
            for (int i = k; i < nums.length; i++) {
                //此时的temArr[0]就是堆里面最小的，，，如果比最小的大，就放进来
                if (nums[i] > tempArr[0]) {
                    tempArr[0] = nums[i];
                    //因为是和堆顶进行的对换，，，所以将堆顶0放入调整堆节点中
                    heapify(tempArr, k - 1, 0);
                }
            }
            return tempArr[0];
        }

        /**
         * 调整堆,,,也就是调整当前节点对应的父子节点       维护一个小根堆
         *
         * @param nums 数组
         * @param n    最大节点数，避免超
         * @param i    当前节点
         */
        public void heapify(int nums[], int n, int i) {
            //while (true) {
            //当前节点
            int minPosition = i;
            //左孩子
            int left = i * 2 + 1;
            //右孩子
            int right = left + 1;
            if (left <= n && nums[minPosition] > nums[left]) {
                //此时最小值是左孩子
                minPosition = left;
            }
            if (right <= n && nums[minPosition] > nums[right]) {
                //此时最小值是右孩子
                minPosition = right;
            }
            ////如果此时最小值节点还是当前节点，不用调整，直接结束
            if (minPosition == i) {
                return;
            }
            //交换位置,,,,,,需要检查交换的那个节点有没有问题
            int temp = nums[i];
            nums[i] = nums[minPosition];
            nums[minPosition] = temp;
            heapify(nums, n, minPosition);
            //i = minPosition;
            //}
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new Array_215().new Solution().findKthLargest(ints, 3));
    }
}
