// 前缀树、字典树实现
public class Trie {

    // 根节点
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static class TrieNode {
        // 多叉树
        private TrieNode[] children;

        //是否为结尾
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    /**
     * 向字典树中插入单词
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }

    /**
     * 在前缀树中查询单词
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return temp.isWord;
    }

    /**
     * 前缀树中是否有prefix前缀
     *
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {
        TrieNode temp = root;
        for (char c : prefix.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return true;
    }
}
