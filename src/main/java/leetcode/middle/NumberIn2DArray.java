package leetcode.middle;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean a = true, b = true;
        int x = matrix.length;

        if(x == 0) return false;
        int y = matrix[0].length;
        if(y == 0) return false;
        int _x = 0, _y = 0;
        int max = Math.max(x, y);

        for (int i = 0; i < max; i++) {
            if (a && i < y && matrix[0][i] <= target) {
                if (matrix[0][i] == target) return true;
                _y++;
            }else a = false;

            if (b && i < x && matrix[i][0] <= target) {
                if (matrix[i][0] == target) return true;
                _x++;
            }else b = false;
        }

        for (int i = 0; i < _x; i++) {
            for (int j = 0; j < _y; j++) {
                if (matrix[i][j] == target) return true;
            }
        }

        return false;
    }
}
