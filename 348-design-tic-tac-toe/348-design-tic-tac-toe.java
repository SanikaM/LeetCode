class TicTacToe {
    
    int[] rows;
    int[] cols;
    int diag;
    int anti_diag;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
             
    }
    
    public int move(int row, int col, int player) {
        int curr_player = (player == 1) ? 1 : -1;
        
        rows[row] += curr_player;
        cols[col] += curr_player;
        
        if(row == col)
            diag += curr_player;
        if(row+ col == cols.length-1)
            anti_diag += curr_player;
        
        int n = rows.length;
        
        if(Math.abs(rows[row]) ==n || Math.abs(cols[col]) ==n || Math.abs(diag) == n || Math.abs(anti_diag) ==n)
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */