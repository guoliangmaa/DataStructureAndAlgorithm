package leetcode.simple;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0,n);
        String s2 = s.substring(n,s.length());

        StringBuilder sb = new StringBuilder();
        sb.append(s2);
        sb.append(s1);

        return sb.toString();
    }
}
