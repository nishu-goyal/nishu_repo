class Solution {
    public String fractionToDecimal(int num, int den) {
        if(num==0)
            return "0";
        String ans="";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if(num<0 && den<0)
            ans="";
        else if(num<0 || den<0)
            ans="-";
        Long res=Math.abs((long)num);
        long de = Math.abs((long)den);
        ans=ans+""+res/de;
        if(res%de==0)
            return ans;
        res=res%de;
        ans=ans+".";
        map.put(res, ans.length());
        while(res!=0)
        {
            res=res*10;
            ans=ans+""+res/de;
            res=res%de;
           
            if(map.containsKey(res))
            {
                int index=map.get(res);
                ans=ans.substring(0,index)+"("+ans.substring(index);
                ans=ans+")";
                break;
               
            }
            else
            {
                 map.put(res,ans.length());
            }
        }
        return ans;
    }
}
