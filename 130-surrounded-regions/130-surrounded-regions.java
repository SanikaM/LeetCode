class Solution {
    
    
    
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        List<Pair<Integer, Integer>> ele = new ArrayList<>();
        
        for(int r=0;r<rows;r++){
            ele.add(new Pair(r, 0));
            ele.add(new Pair(r, cols-1));
        }
        for(int c=0;c<cols;c++) {
            ele.add(new Pair(0,c));
            ele.add(new Pair(rows-1,c));
        }
        
        for(Pair<Integer, Integer> p : ele) {
            dfs(board, p.first, p.second);
        }
        
        for(int r=0; r<rows; r++) {
            for(int c=0;c<cols;c++) {
                
                if(board[r][c] == 'O')
                    board[r][c] = 'X';
                if(board[r][c] == 'E')
                    board[r][c] = 'O';
            }
        }
        
    }
    
    private void dfs(char[][] board, int r, int c) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        if(board[r][c] != 'O')
            return;
        
        board[r][c] = 'E';
        
        if(c < cols-1)
            dfs(board, r, c+1);
        if(c >0)
            dfs(board, r, c-1);
        if(r < rows-1)
            dfs(board, r+1, c);
        if(r > 0)
            dfs(board, r-1, c);
    }
}

class Pair<U, V> {
    
    public U first;
    public V second;
    
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}