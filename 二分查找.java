

// 二分查找
// 查找第一个大于等于给定值的元素

private int bin_up(int[] nums,int val)
{
    int n = nums.length;
    int left=0,right=n-1;
    while(left<right)
    {
        int mid = left+(right-left)/2;
        if(nums[mid]>=val)
        {
            right=mid;
        }
        else 
        {
            left=mid+1
        }
    }
    return nums[right]>=val ? right:-1;
}

private int bin_low(int[] nums,int val)
{
    int n = nums.length;
    int left=0,right=n-1;
    while(left<right)
    {
        int mid=left+(right-left+1)/2;
        if(nums[mid]<=val)
        {
            left=mid;
        }
        else 
        {
            right=mid-1;
        }
    }
    return nums[left]<=val? left:-1;
}