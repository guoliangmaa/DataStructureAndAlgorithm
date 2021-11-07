package leetcode.middle;

/**
 * 求最长回文子串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome instance = new LongestPalindrome();

        System.out.println(instance.longestPalindrome("abba"));
    }
    //中心扩散法
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 2) return s;

        int begin = 0, maxLength = 1;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;

            left = i - 1;
            right = i + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
               --left;
               ++len;
            }

            while (right < s.length() && s.charAt(right) == s.charAt(i)){
                ++right;
                ++len;
            }


            while (left >= 0 && right < s.length()){
                if (s.charAt(left) == s.charAt(right)){
                    --left;
                    ++right;
                    len += 2;
                }else break;
            }

            if (len >= maxLength) {
                maxLength = len;
                begin = left;
            }
        }

        //因为每次left最终都会减到 正确答案的前一位 非常重要，思考
        return s.substring(begin + 1,begin + maxLength + 1);
    }


    //动态规划法
    public String otherMethod1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart + 1, maxEnd + 1);

    }

}
