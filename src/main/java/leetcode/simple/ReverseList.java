package leetcode.simple;

import java.util.ArrayList;
import java.util.List;

//翻转链表
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = null;

        while (head != null){
            ListNode temp = head.next;
            head.next = cur;

            cur = head;
            head = temp;

        }
        return cur;
    }

    private ListNode another(ListNode head) {
        if (head == null || head.next == null) return head;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode res = new ListNode(0);
        ListNode var = res;
        int len = list.size();

        for (int i = len - 1; i >=0 ;i--) {
            ListNode temp = new ListNode(list.get(i));
            var.next = temp;

            var = temp;
        }

        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}