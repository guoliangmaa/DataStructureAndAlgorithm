package leetcode.middle;

public class TreeSubStruct {

    //判断B是不是A的子结构
    public boolean _isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;

        return mothod(A,B);
    }

    private boolean mothod(TreeNode A, TreeNode B){

        if (B == null) return true;
        if (A == null) return false;

        if (A.val == B.val) {
            return mothod(A.left,B.left) && mothod(A.right,B.right);
        }else {
            return mothod(A.right,B) || mothod(A.left,B);
        }
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
