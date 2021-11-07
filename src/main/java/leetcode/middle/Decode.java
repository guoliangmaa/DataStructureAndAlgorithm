package leetcode.middle;

/**
 * 数字解码
 */
public class Decode {

    public static void main(String[] args) {
        Decode decode = new Decode();
        //System.out.println(decode.numDecodings("111111111111111111111111111111111111111111111")); //1836311903
        System.out.println(decode.numDecodings("12")); //1836311903
    }

    private int sum = 0;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        if(s.charAt(0) == '0') return 0;

        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 1; i < len; i++) {
            if (arr[i] == '0') {
                if (arr[i - 1] == '1' || arr[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else return 0;
            }else {
                if (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] <= '6')) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }else {
                    dp[i+1] = dp[i];
                }
            }
        }

        return dp[len];
    }

    public void deal(String str) {
        if (str == null || str.length() == 0) return;

        if (str.length() == 1) {
            if (!str.equals("0")) sum++;
            return;
        }

        if (str.length() == 2) {

            if (str.charAt(0) != '0' && Integer.parseInt(str) <= 26) sum++;
            else if (str.charAt(0) == '0') return;
        }

        if (str.charAt(0) != '0')
            deal(str.substring(1, str.length()));

        if (str.charAt(0) != '0' && Integer.parseInt(str.substring(0, 2)) <= 26)
            deal(str.substring(2, str.length()));
    }
}
