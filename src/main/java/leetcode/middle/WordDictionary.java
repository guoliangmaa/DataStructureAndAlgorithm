package leetcode.middle;

public class WordDictionary {
    private WordDictionary[] items;
    boolean isEnd;

    public WordDictionary() {
        items = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary curr = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.items[index] == null)
                curr.items[index] = new WordDictionary();
            curr = curr.items[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(this, word, 0);
    }

    private boolean search(WordDictionary curr, String word, int start) {
        int n = word.length();
        if (start == n)
            return curr.isEnd;
        char c = word.charAt(start);
        if (c != '.') {
            WordDictionary item = curr.items[c - 'a'];
            return item != null && search(item, word, start + 1);
        }

        for (int j = 0; j < 26; j++) {
            if (curr.items[j] != null && search(curr.items[j], word, start + 1))
                return true;
        }
        return false;
    }
}
