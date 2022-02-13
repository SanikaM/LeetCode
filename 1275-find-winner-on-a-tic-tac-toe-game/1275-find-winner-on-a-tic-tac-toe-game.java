class Solution {
    public String tictactoe(int[][] moves) {
        int n =3;
        
        int[] rows = new int[n];
        int[] cols = new int[n];
        
        int diag = 0;
        int anti_diag = 0;
        
        int player =1;
        
        for(int[] mov : moves){
            
            int row = mov[0];
            int col = mov[1];
            
            rows[row] += player;
            cols[col] += player;
            
            if(row == col)
                diag += player;
            if(row + col == n-1)
                anti_diag += player;
            
            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(anti_diag) == n){
                return player ==1 ? "A" : "B";
            }
            
            player *= -1;
        }
        
        return moves.length == n * n ?  "Draw" : "Pending";
    }
}