// Time Complexity - 

// let:
// N = num of rows
// M = num of columns
// X = number of words in dictionary
// Y = length of longest word in dictionary

// Time complexity of using a set instead of a trie tree

// We are doing a 4-child DFS traversal of depth N*M (worst case is traversing entire board). -> 4^(NM)
// We are doing this N*M times since we need to check for words starting at each position in the board
// -> O(4^(NM)*NM)
// Time complexity of using the trie tree

// We are doing a 4-child DFS traversal.
// The worst case depth in this case is the minimum of [traversing the entire board, traversing until we hit the end of a word].
// -> O of each traversal is4^(min(Y, NM))
// Note: min accounts for the case where we have words in the dictionary longer than the number of characters in the board itself.
// We are doing this N*M times since we need to check for words starting at each position in the board
// -> O(4^(min(Y, NM))*NM)
// credits to @aaardvark on leetcode.com

class Solution {
    private int row, col;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        
        Trie trie = new Trie();
        
        for(String word : words)
            trie.insert(word);
        
        row = board.length;
        col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dfs(board, visited, "", i, j, trie, result);
            }
        }
        
        return new ArrayList<>(result);
    }
    
    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie, Set<String> result){
        if(x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) return;
        
        str += board[x][y];
        if(!trie.startsWith(str)) return;
        
        if(trie.search(str))
            result.add(str);
        
        visited[x][y] = true;
        
        dfs(board, visited, str, x - 1, y, trie, result);
        dfs(board, visited, str, x + 1, y, trie, result);
        dfs(board, visited, str, x, y - 1, trie, result);
        dfs(board, visited, str, x, y + 1, trie, result);
        
        visited[x][y] = false;
    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
}

class Trie {
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null){
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null)
                return false;
            current = current.children[c - 'a'];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix){
        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(current.children[c - 'a'] == null)
                return false;
            current = current.children[c - 'a'];
        }
        return true;
    }
}