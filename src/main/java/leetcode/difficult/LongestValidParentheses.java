package leetcode.difficult;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();

        System.out.println(obj.finalMethod(")()())()()("));
    }

    /**
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
     * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的
     * 「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为
     * 「以该右括号为结尾的最长有效括号的长度」
     *
     * @param s
     * @return
     */
    public int finalMethod(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses(String s) {
        int i1 = method('(',s);
        int i2 = method(')',new StringBuilder(s).reverse().toString());

        System.out.println(i2);
        System.out.println(i1);
        return Math.max(i2,i1);
    }

    private int method(char head,String s){
        char[] arr = s.toCharArray();

        int max = 0, temp = 0;
        int valid = 0, left = 0, right = 0; //校验
        int len = arr.length;
        int i = 0;
        while (i < len) {
            char c = arr[i];
            if (c == head) {
                //valid++;
                left++;

                if(left - right >= len - i){
                    max = Math.max(max, 2 * temp);
                    break;
                }
            } else {
                //valid--;
                right++;

                if (left >= right) {

                    temp++;
                }
            }

            if (left < right) {
                max = Math.max(max, 2 * temp);
                left = 0;
                right = 0;
                temp = 0;
            }
            else {
                if (i == len - 1) {
                    max = Math.max(max, 2 * temp);
                }
            }

            i++;
        }

        return max;
    }
}
