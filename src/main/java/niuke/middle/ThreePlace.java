package niuke.middle;

import java.util.Scanner;

public class ThreePlace {

    public static void main(String[] args) {
        int n,d;

        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        String[] s = line1.split(" ");
        n = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);

        String[] s1 = line2.split(" ");
        int[] array = new int[s1.length];

        for (int i = 0; i < s1.length; i++) {
            array[i] = Integer.parseInt(s1[i]);
        }
//        System.out.println(n + d);
//        System.out.println(line2);
        System.out.println(result(array, n, d));
    }


    public static int result(int[] array, int n, int d){
        return 0;
    }
}
