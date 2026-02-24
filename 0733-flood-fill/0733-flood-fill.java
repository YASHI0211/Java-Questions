class Solution {
    int rows;
    int cols;
    void dfs(int row, int col, int newColor, int curColor, boolean visited[][], int image [][]){
        if (row<0||row>=rows || col<0 || col>=cols || image[row][col]!=curColor || visited[row][col]){
            return;
        }
        image[row][col]= newColor;
        visited[row][col]= true;
        int adjList[][]= {{row-1, col}, {row, col+1},{row+1, col},{row, col-1}};
        for (int neighbour[]: adjList){
            dfs(neighbour[0], neighbour[1], newColor, curColor,visited,image);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        boolean [][] visited = new boolean [rows][cols];
        dfs(sr, sc, color, image[sr][sc], visited, image);
        return image; 
    }
}