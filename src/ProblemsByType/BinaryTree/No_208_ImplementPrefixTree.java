package ProblemsByType.BinaryTree;

public class No_208_ImplementPrefixTree
{
    class Trie {
        // �ؼ����ǰ׺������ṹ��ÿ������Ӧ�ַ����е�һ���ַ���ÿ����������һ��26��С���ӽ������Trie[26] children����ǰ�ַ�����һ���ַ��Ƿ���ڣ���һ���Ƿ�Ϊ�����ַ���boolean���isEnd����ǰ�ַ��Ƿ�Ϊһ�����ʵĽ����ַ���
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
