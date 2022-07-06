import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * @author yan
 * @date 2022/7/3
 */
public class Tree_103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> deque = new LinkedList<>();
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            deque.add(root);
            int ans = 0;
            while (!deque.isEmpty()) {
                ans++;
                int size = deque.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.add(node.left);
                    }
                    if (node.right != null) {
                        deque.add(node.right);
                    }
                }
                if (ans % 2 == 0) {
                    //将集合翻转
                    Collections.reverse(list);
                }
                lists.add(list);
            }
            return lists;
        }
    }

    public static void main(String[] args) {
        //[1,2,3,4,null,null,5]

        TreeNode treeNode2 = new TreeNode(5, null, null);
        TreeNode treeNode3 = new TreeNode(4, null, null);
        TreeNode treeNode1 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode4 = new TreeNode(3, treeNode2, null);
        TreeNode treeNode = new TreeNode(1, treeNode1, treeNode4);
        List<List<Integer>> lists = new Tree_103().new Solution().zigzagLevelOrder(treeNode);

    }
}
