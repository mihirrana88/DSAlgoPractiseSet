package DS.Trie;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

*/

public class WordSearchII {
    char[][] board = null;
    public String[] words = null;

    public void getInputLength(int row, int column){
        board = new char[row][column];
    }

    public void acceptInput(char ch, int row, int column){
        if(row < 0 || column < 0 || row > board.length-1 || column > board[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        board[row][column] = ch;
    }

    public void acceptInput(String input) throws Exception {
        if(null == input || input.length() == 0){
            throw new InvalidInputArgument(input);
        }
        char[] inputCharArray = input.toCharArray();
        this.words = new String[inputCharArray.length];
        for (int i=0; i < inputCharArray.length; i++){
            this.words[i] = String.valueOf(inputCharArray[i]);
        }
    }

    public List<String> findWords() {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i=0; i< words.length; i++) {
            TrieNode p = root;
            for (int j=0; j<words[i].toCharArray().length; j++) {
                int k = words[i].toCharArray()[j]- 'a';
                if (p.next[k] == null) {
                    p.next[k] = new TrieNode();
                }
                p = p.next[k];
            }
            p.word = words[i];
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
