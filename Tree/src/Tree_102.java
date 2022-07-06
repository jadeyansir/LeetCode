import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * 在每一层遍历开始前，先记录队列中的结点数量 nn（也就是这一层的结点数量），然后一口气处理完这一层的 nn 个结点。
 *
 * @author yan
 * @date 2022/7/3
 */
public class Tree_102 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            //使用队列作为存放每层数据的容器
            //每次取一层来进行读取
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            //当队列为空时进行结束
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                //先取出队列的大小，，，表示的是此层节点的数量
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    //将下层数据放入队列中，，，因为只取本层数据，，所以不会去除下层数据
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                lists.add(list);
            }
            return lists;
        }
    }

    public static void main(String[] args) {
        //3,9,20,null,null,15,7

        TreeNode treeNode1 = new TreeNode(9, null, null);
        TreeNode treeNode2 = new TreeNode(15, null, null);
        TreeNode treeNode3 = new TreeNode(7, null, null);
        TreeNode treeNode4 = new TreeNode(20, treeNode2, treeNode3);
        TreeNode treeNode = new TreeNode(3, treeNode1, treeNode4);
        List<List<Integer>> lists = new Tree_102().new Solution().levelOrder(treeNode);

    }
}
