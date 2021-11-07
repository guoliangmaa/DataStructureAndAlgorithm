package niuke.middle;

import java.util.Arrays;
import java.util.Scanner;

//牛客 - 字节 - 2019 第一题  修改为正确单词
public class CorrectWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < arr.length; i++) {
            sb = new StringBuilder();

            char[] chars = arr[i].toCharArray();
            int len = chars.length;
            int j;
            for (j = 0; j < len;) { //先去掉三个以上重复字符
                sb.append(chars[j]);

                char c = chars[j];

                if (j + 1 < len && chars[j] == chars[j + 1]) {
                    sb.append(chars[j + 1]);
                    int k = j + 1;
                    while (k < len && c == chars[k]){
                        k++;
                    }
                    j = k;
                }
                else j++;
            }

            arr[i] = sb.toString();

            chars = arr[i].toCharArray();
            len = chars.length;
            sb = new StringBuilder();
            for (int m = 0; m < len; ) {  //去掉另一种重复
                sb.append(chars[m]);
                if (m + 1 < len && chars[m + 1] == chars[m]) {
                    if (m + 3 < len && chars[m + 2] == chars[m + 3]) {
                        sb.append(chars[m + 1]);
                        sb.append(chars[m + 2]);
                        m += 4;
                        continue;
                    }
                }
                m++;

            }
            arr[i] = sb.toString();
            System.out.println(arr[i]);
        }

        //System.out.println(Arrays.toString(arr));
    }


}
