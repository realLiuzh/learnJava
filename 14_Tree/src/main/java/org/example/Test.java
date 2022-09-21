import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// @solution-sync:begin
/**
 思路：构建字典树
 后缀
 对于每一个字符串s，先检查其是否是当前树的后缀。
 如果不是就将s构建到字典树中。
 1、后缀
 中序遍历树（×）
 双向
 */
class Test {
    class TrieNode{
        TrieNode[] child;
        TrieNode pre;
        char value;
        boolean isWord;

        public TrieNode(){
            child=new TrieNode[26];
        }
    }

    TrieNode root=new TrieNode();
    List<TrieNode> list=new ArrayList<>();
    public int minimumLengthEncoding(String[] words) {
        int count=0;
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
//        for(String s:words){
//            if(isExist(s)) continue;
//            build(s);
//            count=count+s.length()+1;
//        }
        return count;
    }
    boolean isExist(String s){
        if(list.size()==0) return false;
        for(TrieNode node:list){
            int i=s.length()-1;
            while(i>=0&&node!=null&&node!=root){
                if(node.value!=s.charAt(i)) break;
                node=node.pre;
                i--;
            }
            if(i<0) return true;
        }
        return false;
    }

    void build(String s){
        TrieNode node=root;
        for(char c:s.toCharArray()){
            if(node.child[c-'a']==null){
                TrieNode newNode=new TrieNode();
                newNode.value=c;
                newNode.pre=node;
                node.child[c-'a']=newNode;
            }
            node=node.child[c-'a'];
        }
        node.isWord=true;
        list.add(node);
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        String[] words = new String[]{"time", "me", "bell"};

        int result = new Test().minimumLengthEncoding(words);
        System.out.println(result);
    }

}
