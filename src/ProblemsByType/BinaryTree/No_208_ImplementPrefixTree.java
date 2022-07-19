package ProblemsByType.BinaryTree;

public class No_208_ImplementPrefixTree
{
    class Trie {
        // 关键理解前缀树的类结构：每个结点对应字符串中的一个字符，每个树结点包含一个26大小的子结点数组Trie[26] children代表当前字符的下一个字符是否存在，与一个是否为结束字符的boolean标记isEnd代表当前字符是否为一个单词的结束字符。
        Trie[] children;
        boolean isEnd;
        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie cur = this;
            for(int i = 0; i < chars.length; i++){
                char ch = chars[i];
                if(cur.children[ch - 'a'] == null){
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
                if(i == chars.length - 1){
                    cur.isEnd = true;
                }
            }
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Trie cur = this;
            for(int i = 0; i < chars.length; i++){
                char ch = chars[i];
                if(cur.children[ch - 'a'] == null){
                    return false;
                }
                cur = cur.children[ch - 'a'];
                if(i == chars.length - 1 && cur.isEnd){
                    return true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Trie cur = this;
            for(int i = 0; i < chars.length; i++){
                char ch = chars[i];
                if(cur.children[ch - 'a'] == null){
                    return false;
                }
                cur = cur.children[ch - 'a'];
            }
            return true;
        }
    }
}
