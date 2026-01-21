class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
                curr = curr.children[c-'a'];
            }
            curr.word = w;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) dfs(board, i, j, root, res);
        return res;
    }
    private void dfs(char[][] b, int r, int c, TrieNode node, List<String> res) {
        char ch = b[r][c];
        if (ch == '#' || node.children[ch-'a'] == null) return;
        node = node.children[ch-'a'];
        if (node.word != null) { res.add(node.word); node.word = null; }
        b[r][c] = '#';
        int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < b.length && nc >= 0 && nc < b[0].length) dfs(b, nr, nc, node, res);
        }
        b[r][c] = ch;
    }
}