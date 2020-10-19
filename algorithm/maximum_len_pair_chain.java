class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] t=new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        for(int i=0;i<pairs.length;i++)
            t[i]=1;
        
        for(int i=1;i<pairs.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(pairs[i][0]>pairs[j][1] && t[i]<1+t[j])
                    t[i]=t[j]+1;
            }
        }
       
        int max=0;
        for(int i=0;i<pairs.length;i++)
        {
            if(t[i]>max)
                max=t[i];
        }
        return max;
    }
}
