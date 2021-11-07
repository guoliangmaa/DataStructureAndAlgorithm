package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

//括号生成函数
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParenthesis obj = new GenerateParenthesis();

        System.out.println(obj.generateParenthesis(5));
    }
    private List<String> method(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        if (n == 1) {
            list.add("()");
            return list;
        }

        for (int i = 1; i < n; i++) {

        }

        return null;
    }


    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }
}
