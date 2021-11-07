package leetcode.middle.expire;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private Map<String,Boolean> map = new HashMap<>();
    //private Map<String,Boolean> cache = new HashMap<>();

    public WordDictionary() {

    }

    public void addWord(String word) {
        map.put(word,false);
    }

    public boolean search(String word) {
        if (map.containsKey(word)) return true;

        //if (cache.containsKey(word)) return true;

        for (String str : map.keySet()){
            if (str.length() == word.length()){
                char[] array1 = str.toCharArray();
                char[] array2 = word.toCharArray();

                for (int i = 0; i < array1.length; i++) {
                    if (!(array1[i] == array2[i] || array2[i] == '.')) break;

                    if (i == array1.length - 1){
                        map.put(word,false);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
