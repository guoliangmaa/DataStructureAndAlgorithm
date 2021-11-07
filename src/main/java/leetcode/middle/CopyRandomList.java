package leetcode.middle;

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Node _head = new Node(0);

        Node res = _head; //最终结果

        Node temp = head;

        while (temp != null) {
            Node _temp = new Node(temp.val);
            _head.next = _temp;
            _head = _temp;

            temp = temp.next;
        }

        Node n1 = res.next, n11 = res.next, n2 = head, n22 = head;

        while (n2 != null){
            n22 = head;
            n11 = res.next;
            while (n22 != null){
                if (n2.random == n22) {
                    n1.random = n11;
                    break;
                }else {
                    n22 = n22.next;
                    n11 = n11.next;
                }
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return res.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}