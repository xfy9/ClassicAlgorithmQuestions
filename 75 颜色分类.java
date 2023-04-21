// 75 颜色分类
// 荷兰国旗问题
class Solution {
    private void swap(int locx,int locy,int[] nums)
    {
        int temp = nums[locx];
        nums[locx]=nums[locy];
        nums[locy]=temp;
    }
    public void sortColors(int[] nums) {
        int len = nums.length;
        int start=0,end=len-1,now=0;
        while (now<=end)
        {

            while(now<=end&&nums[now]==2)
            {
                swap(end,now,nums);
                end--;
            }
            if(nums[now]==0)
            {
                swap(start,now,nums);
                start++;
            }
            now++;
        }
    }
}