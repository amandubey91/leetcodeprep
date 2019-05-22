package Trie;

import java.util.ArrayList;
import java.util.List;

//Given a 2D board and a word, find if the word exists in the grid.
public class WordSearch_II {

    public static void main(String[] args){

//        Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//                Each word must be constructed from letters of sequentially adjacent cell,
//        where "adjacent" cells are those horizontally or vertically neighboring.
//                The same letter cell may not be used more than once in a word.
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'D'},
                {'P', 'R', 'A', 'T'},
                {'K', 'I', 'T', 'A'},
                {'A', 'N', 'D', 'Y'},
        };
        //patternSearch(board, "ARCD");

    }
//    Intuitively, start from every cell and try to build a word in the dictionary.
//            Backtracking (dfs) is the powerful way to exhaust every possible ways.
//            Apparently, we need to do pruning when current character is not in any word.
//
//            How do we instantly know the current character is invalid? HashMap?
//    How do we instantly know what's the next valid character? LinkedList?
//    But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
//    Combing them, Trie is the natural choice.
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res, visited);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res, boolean[][] visited) {
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || visited[i][j]){
            return;
        }
        char c = board[i][j];

        if (p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        visited[i][j] = true;
        dfs(board, i - 1, j ,p, res, visited);
        dfs(board, i, j - 1, p, res, visited);
        dfs(board, i + 1, j, p, res, visited);
        dfs(board, i, j + 1, p, res, visited);
        visited[i][j] = false;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
