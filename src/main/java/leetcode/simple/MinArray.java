package leetcode.simple;

//旋转数组的最小数字
public class MinArray {

    public int minArray(int[] numbers) {
        int len = numbers.length;

        for (int i = len -1; i >0 ; i--) {
            if (numbers[i-1] > numbers[i]) return numbers[i-1];
        }

        return numbers[0];
    }
}
