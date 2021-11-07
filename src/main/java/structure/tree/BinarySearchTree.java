package structure.tree;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree extends BinaryTree{

    public final TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(5);

        tree.insert(4);
        tree.insert(5);
        tree.insert(9);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree.levelOrderBottom(tree.root));
    }


    public BinarySearchTree(int value) {
        root = new TreeNode();
        root.val = value;
    }

    public void insert(int value) {
        TreeNode temp = root;
        TreeNode pre = null;
        while (temp != null) {
            pre = temp;

            if (value < temp.val) temp = temp.left;
            else temp = temp.right;
        }

        if (value < pre.val) pre.left = new TreeNode(value);
        else pre.right = new TreeNode(value);

    }


    public void balanceBST() {

    }
}
