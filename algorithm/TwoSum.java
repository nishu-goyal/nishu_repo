class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] a= new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]) == false)
                map.put(nums[i],i);
            else
            {
                a[0]=map.get(target-nums[i]);
                a[1]=i;
                break;
            }
        }        
        return a;
    }
}
