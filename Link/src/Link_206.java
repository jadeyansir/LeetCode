/**
 * 206. 反转链表
 *
 * @author yan
 * @date 2022/6/23
 */
public class Link_206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            //新建一个指向空的指针
            ListNode pre = null;
            while (head != null) {
                //新建一个临时节点，，用于记录下一个节点位置，，，方便断开指针后可以找到下一个
                ListNode temp = head.next;
                //将head节点指向pre
                head.next = pre;
                //将pre指针向前移动一个，即放在head位置上
                pre = head;
                //head移动到下一个，也就是head.next
                head = temp;
            }
            return pre;
        }
    }
}
