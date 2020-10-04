class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row=new int[grid.length];
        int[] col=new int[grid.length];
        
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid.length;++j)
            {
                row[i]=Math.max(row[i],grid[i][j]);
                col[j]=Math.max(col[j],grid[i][j]);
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid.length;j++)
                ans += Math.min(row[i],col[j])-grid[i][j];
        
        return ans;
    }
}
