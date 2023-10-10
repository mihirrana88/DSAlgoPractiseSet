package DS.Trie2;

/*
* Simple implementation of Trie
*
* It's a simple Trie used to store words containing small letter alphabets(a-z).
* We'll define two function insert and search
*
* Insert: Insert operation will insert given word to existing trie structure
* Search: Search operation will search given word in try and return boolean if present or not
*
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrieNode {
  TrieNode[] children;
  boolean isWordEnd;

  public TrieNode(){
    this.children = new TrieNode[26];
    this.isWordEnd = false;
  }

  public void insert(TrieNode root, String word){
    TrieNode crt = root;
    for(int i=0; i<word.length(); i++){
      if(crt.children[word.charAt(i)-'a'] == null){
        TrieNode tmp = new TrieNode();
        crt.children[word.charAt(i)-'a'] = tmp;
      }
      crt = crt.children[word.charAt(i)-'a'];
    }
    crt.isWordEnd = true;
  }

  public boolean search(TrieNode root, String word){
    TrieNode crt = root;
    for(int i=0; i<word.length(); i++){
      if(crt.children[word.charAt(i)-'a'] == null){
        return false;
      }
      crt = crt.children[word.charAt(i)-'a'];
    }
    return crt.isWordEnd;
  }

  public void wordsStartsWith(TrieNode root, String startsWith){
    TrieNode crt = root;
    for(int i=0; i<startsWith.length(); i++){
      if(null == crt.children[startsWith.charAt(i)-'a']){
        return;
      }
      crt = crt.children[startsWith.charAt(i)-'a'];
    }
    if(null != crt){
      char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                      'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                      'y', 'z'};
      StringBuilder sb = new StringBuilder(startsWith);
      if(isWordEnd)System.out.println(sb);
      Stack<Pair> stack = new Stack<>();
      stack.push(new Pair(crt, new StringBuilder(startsWith)));
      while (!stack.isEmpty()){
        Pair pair = stack.pop();
        if(pair.node.isWordEnd){
          System.out.println(pair.sb);
        }
        List<Character> list = new ArrayList<>();
        for(int i=0; i<26; i++){
          if(null != pair.node.children[i]){
            list.add(chars[i]);
            stack.push(new Pair(pair.node.children[i], new StringBuilder(pair.sb).append(chars[i])));
          }
        }
      }
    }
  }

  class Pair{
    TrieNode node;
    StringBuilder sb;
    public Pair(TrieNode node, StringBuilder sb){
      this.node = node;
      this.sb = sb;
    }
  }
}
