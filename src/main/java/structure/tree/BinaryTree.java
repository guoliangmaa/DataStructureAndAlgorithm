package structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list;
    }
    //中序遍历的 工具函数
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //层序遍历,题目要求 自底向上的层序遍历，用list的链式存储更方便，采用头插法
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();

                if (head == null) continue;

                lst.add(head.val);
                queue.add(head.left);
                queue.add(head.right);
            }

            if (lst.size() > 0) list.add(0, lst);
        }
        return list;
    }

    //判断树是否平衡
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int range = height(root.left) - height(root.right);
        return (range >= -1 && range <= 1 && isBalanced(root.left) && isBalanced(root.right)) ;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        int max = left > right ? left + 1 : right + 1;

        return max;
    }
}
