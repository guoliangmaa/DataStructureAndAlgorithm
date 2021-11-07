package leetcode.middle;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Z {

    public static void main(String[] args) {
//        new Z().convert("PAYPALISHIRING",3);
//        new Z().convert("A",1);
        new Z().convert("ABC",2);

    }

    public String convert(String s, int numRows) {

        if (s.length() <= numRows || numRows == 1) return s;

        char[][] array = new char[numRows][s.length() / 2 + 1];

        char[] chars = s.toCharArray();

        boolean b = true; //竖向?
        int index = 0;
        int current = 0; //当前在第几列

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {

            if (b) {
                if (index < numRows - 1){
                    array[index++][current] = c;
                    if (index >= numRows - 1) b = false;
                }

                else
                    b = false;
            }else{
                    array[index--][current++] = c;

                    if (index == 0) b = true;
            }

        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length() / 2 + 1; j++) {
                if (array[i][j] != 0) {
                    sb.append(array[i][j]);
                    System.out.print(array[i][j]);
                }
            }
        }
        System.out.println();
        return sb.toString();
    }
}
