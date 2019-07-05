class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            dfs(board, click);
            return board;
        }
    }
    
    private void dfs(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            if (board[row][col] == 'E') {
                int num = 0;
                for (int[] d:dir) {
                    int x = row+d[0], y = col+d[1];
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                        if (board[x][y] == 'M'){
                            num++;
                        } 
                    } 
                }
                if (num > 0) {
                    board[row][col] = Character.forDigit(num, 10);
                } else {
                    board[row][col] = 'B';
                    for (int[] d:dir) {
                        dfs(board, new int[] {row+d[0], col+d[1]});
                    }
                }
                
            }
        }
    }
}
