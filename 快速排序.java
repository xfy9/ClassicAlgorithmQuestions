//  快速排序 
//  快速排序取中间元素作为哨兵元素 将第一个元素与随机元素交换

class Solution {
    public int quickSelect(int[] nums,int left,int right)
    {
        int target = nums[(left+right)/2];
        int start = left,end = right;
        // swap
        int temp  = nums[left];
        nums[left]=target;
        nums[(left+right)/2]=temp;
        while(start<end)
        {
            while(start<end&&nums[end]>=target) end--;
            nums[start]=nums[end];
            while(start<end&&nums[start]<=target) start++;
            nums[end]=nums[start];
        }
        nums[start]=target;
        return start;
    }
    public void quickSort(int[] nums,int left,int right)
    {
        if(left>=right) return;
        int loc = quickSelect(nums,left,right);
        quickSort(nums,left,loc-1);
        quickSort(nums,loc+1,right);
    }
}