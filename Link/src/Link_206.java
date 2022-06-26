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
            ListNode pre = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
    }
}
