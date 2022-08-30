/**
 * 创建链表工具类
 *
 * @author yan
 * @date 2022/8/31
 */
public class LinkedListUtils {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(ListNode node) {
            this.val = node.val;
            this.next = node.next;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }

        public ListNode getNext() {
            return this.next;
        }

        public void setNext(ListNode node) {
            this.next = node;
        }
    }

    public static ListNode constructListNode(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        for (int i = 0; i < numbers.length; i++) {
            ListNode currNode = new ListNode(numbers[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }

        return dummyNode.next;
    }

    public static ListNode constructListNode(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String listStr = str.replaceAll(" ", "");
        String[] numbersStrArray;
        if (listStr.charAt(0) == '[' && listStr.charAt(listStr.length() - 1) == ']') {
            listStr = listStr.substring(1, listStr.length() - 1);
            numbersStrArray = listStr.split(",");
        } else if (listStr.contains("->")) {
            numbersStrArray = listStr.split("->");
        } else {
            numbersStrArray = new String[1];
            numbersStrArray[0] = listStr;
        }

        int numLength = 0;
        if (numbersStrArray.length > 1) {
            if (numbersStrArray[numbersStrArray.length - 1].equalsIgnoreCase("null")) {
                numLength = numbersStrArray.length - 1;
            } else {
                numLength = numbersStrArray.length;
            }
        } else {
            numLength = 1;
        }

        int[] numbers = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            numbers[i] = Integer.parseInt(numbersStrArray[i]);
        }

        return constructListNode(numbers);
    }

    public static String printLinkedList(ListNode head) {
        if (head == null) {
            return "[]";
        } else if (head.next == null) {
            return "[" + head.val + "]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head.next != null) {
            sb.append(head.val);
            if (head != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append(head.val).append("]");

        return sb.toString();
    }

    public static void printLinkedListPoint(ListNode head) {// 将链表结果打印
        ListNode current = head;
        while (current != null) {
            System.out.printf("%d -> ", current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
}
