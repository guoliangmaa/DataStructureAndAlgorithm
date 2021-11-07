package leetcode.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            Integer i = num;
            if (set.contains(i)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }
}
