class Solution {
    
    private List<List<String>> ans = new ArrayList<>();
    int size;
    public List<List<String>> solveNQueens(int n) {
        
        size = n;
        char[][] emptyBoard = new char[n][n];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                
                emptyBoard[i][j] = '.';
            }
        }
        
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return ans;
    }
    
    private List<String> createBoard(char[][] board) {
        List<String> soln = new ArrayList<>();
        for(int row =0;row<size;row++) {
            String curr_row = new String(board[row]);
            soln.add(curr_row);
        }
        
        return soln;
    }
    private void backtrack(int row, Set<Integer> cols, Set<Integer> p_diag, Set<Integer> n_diag, char[][] board) {
        
        if(row == size) { 
            ans.add(createBoard(board));
            return;
        }
        
        for(int c=0;c<size;c++) {
            
            int curr_diag = row+c;
            int anti_diag = row-c;
            
            if(cols.contains(c) || p_diag.contains(curr_diag) || n_diag.contains(anti_diag)) {
                continue;
            }
            
            cols.add(c);
            p_diag.add(curr_diag);
            n_diag.add(anti_diag);
            board[row][c] = 'Q';
            
            backtrack(row+1, cols, p_diag, n_diag, board);
            
            cols.remove(c);
            p_diag.remove(curr_diag);
            n_diag.remove(anti_diag);
            board[row][c] = '.';
        }
    }
}