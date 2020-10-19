class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        
        int m=matrix.length;
        if(m==0)
            return 0;
        int n=matrix[0].length;
       int[] dp=new int[matrix[0].length];
        int max=0;
        for(int j=0;j<matrix[0].length;j++)
        {   dp[j]=matrix[0][j]-'0';
            max=maxarea(dp);
        }
        int area=0;
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='0')
                    dp[j]=0;
                else
                    dp[j]++;
            }
            
            area=maxarea(dp);
            if(area>max)
                max=area;
        }
        return max;        
    }
    public int maxarea(int[] a){
        int area=0;
        int top=-1;
        int max=0;
        int i;
        Stack<Integer> s=new Stack<>();
        for(i=0;i<a.length;i++)
        {
            if(s.isEmpty() || a[s.peek()]<=a[i])
                s.push(i);
            else{
                while(!s.isEmpty() && a[s.peek()]>a[i])
                {
                    top=s.pop();
                    if(s.isEmpty())
                    {
                        area=a[top]*i;
                    }
                    else
                        area=a[top]*(i-s.peek()-1);
                    
                    if(area>max)
                        max=area;
                }
                s.push(i);
            }
        }
        while(!s.isEmpty())
                {
                    top=s.pop();
                    if(s.isEmpty())
                    {
                        area=a[top]*i;
                    }
                    else
                        area=a[top]*(i-s.peek()-1);
                    
                    if(area>max)
                        max=area;
                }
        return max;
    }
}
