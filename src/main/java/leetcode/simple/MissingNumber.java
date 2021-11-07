package leetcode.simple;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return nums[--i] + 1;
    }
}
