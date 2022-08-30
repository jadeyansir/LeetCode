import java.util.Deque;
import java.util.LinkedList;

/**
 * 构造树
 *
 * @author yan
 * @date 2022/8/31
 */
public class TreeUtils {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        public int val;

        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }
        return root;
    }

    public static void preOrder(TreeNode root) {//前序排列
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void midOrder(TreeNode root) {//中序排列
        if (root == null) return;
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }

    public static void aftOrder(TreeNode root) {//后序排列
        if (root == null) return;
        aftOrder(root.left);
        aftOrder(root.right);
        System.out.print(root.val + " ");
    }
}
