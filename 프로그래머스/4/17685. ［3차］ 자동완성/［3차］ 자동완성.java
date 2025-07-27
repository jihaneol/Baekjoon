import java.util.*;
class TrieNode{
    char node;
    int count;
    TrieNode[] next = new TrieNode[27];
    TrieNode(char word){
        this.node = word;
    }
  
    public int find(String word, int depth){
        if(this.count==1||word.length()==depth+1){
            return depth+1;
        }
     
        return next[word.charAt(depth+1)-'a'].find(word, depth+1);
    }
}
class Trie{
    TrieNode[] root = new TrieNode[27];
    
    public void insert(String word){
        int idx = word.charAt(0)-'a';
        if(root[idx]==null){
            root[idx] = new TrieNode(word.charAt(0));
        } 
        TrieNode current = root[idx];
        for(int i=1; i<word.length(); i++){
            current.count++;
            char node = word.charAt(i);
            if(current.next[node-'a']==null){
                current.next[node-'a'] = new TrieNode(node);
            }
            current = current.next[node-'a'];
           
        }
        current.count++;
    }
    
    public int find(String word){
        TrieNode current = root[word.charAt(0)-'a'];
        for(int i=1; i<word.length(); i++){
            if(current.count==1){
                return i;
            }
            char node = word.charAt(i);
            current = current.next[node-'a'];
        }
        return word.length();
    }
}
class Solution {
    public long solution(String[] words) {
        long answer = 0;
        Trie trie = new Trie();
        
        for(String word : words){
            trie.insert(word);
        }
        for(String word : words){
            answer+=trie.find(word);
     
        }
        return answer;
    }
}