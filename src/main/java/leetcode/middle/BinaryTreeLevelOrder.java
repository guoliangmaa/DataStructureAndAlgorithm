package leetcode.middle;

import java.util.*;

public class BinaryTreeLevelOrder {


    public static void main(String[] args) {
        BinaryTreeLevelOrder tr = new BinaryTreeLevelOrder();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        System.out.println(tr._levelOrder_(n1));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public List<List<Integer>> _levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        int sum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int temp = 0;
            for (int i = 0; i < sum; i++) {
                TreeNode node = queue.poll();
                lst.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    temp++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    temp++;
                }
            }
            list.add(lst);
            sum = temp;
        }

        return list;
    }

    public List<List<Integer>> _levelOrder_(TreeNode root) {
        if (root == null) return new ArrayList<>();
        boolean seq = true; //默认顺序排放
        int sum = 1; //下一次
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> lst = new LinkedList<>();

            int temp = 0;
            int a = 0, b = sum;
            int[] arr = new int[sum];

            for (int i = 0; i < sum; i++) {
                TreeNode node = queue.poll();

                //arr[a++] = node.val;
                if (seq) lst.addLast(node.val);
                else lst.addFirst(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    temp++;
                }

                if (node.right != null) {
                    queue.add(node.right);
                    temp++;
                }
            }
            seq = !seq;
            sum = temp;


            list.add(lst);

        }

        return list;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
