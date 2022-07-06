/**
 * 25. K 个一组翻转链表
 *
 * @author yan
 * @date 2022/6/28
 */
public class Link_25 {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode first = new ListNode(0);
            ListNode pre = first;
            ListNode end = first;

            while (end.next != null) {
                for (int i = 0; i < k - 1 && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                //记录下下一段的位置
                ListNode next = end.next;
                //断开链接
                end.next = null;
                //翻转链表
                ListNode start = pre;
                ListNode node = null;
                while (start != null) {
                    ListNode temp = start.next;
                    start.next = node;
                    node = start;
                    start = temp;
                }
                first.next = end;
                
            }
        }
    }
}
