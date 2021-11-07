package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

//第一次只出现一次的字符
public class FirstUniqueChar {

    public char firstUniqChar(String s) {
        if(s.equals("")) return ' ';

        int length = s.length();
        int[] arr = new int[length];
        int index = 0;

        char[] chars = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> _map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Character c = chars[i];

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c,1);
                _map.put(c,i);
            }
        }
        int minIndex = length - 1;
        boolean b = false;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) {
                if (_map.get(entry.getKey()) <= minIndex) {
                    minIndex = _map.get(entry.getKey());
                    b = true;
                }
            }
        }

        if(!b) return ' ';

        return chars[minIndex];
    }
}
