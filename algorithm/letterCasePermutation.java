class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list=new ArrayList<>();
        compute(list,S.toCharArray(),0);
        return list;
    }
    
    public void compute(List<String> list,char[] chars,int index)
    {
        if(index==chars.length)
            list.add(new String(chars));
        else
        {
            if(Character.isLetter(chars[index]))
            {
                chars[index]=Character.toLowerCase(chars[index]);
                compute(list,chars,index+1);
                chars[index]=Character.toUpperCase(chars[index]);
                compute(list,chars,index+1);
            }
            else
                compute(list,chars,index+1);
        }
    }
}
