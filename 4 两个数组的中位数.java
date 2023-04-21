// 技巧1: 奇数偶数一起讨论:(n+m+1)/2 (n+m+2)/2
// 技巧2: 两个数组分别取第k/2个数，比较，较小的那一组左边删去

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int left = (n+m+1)/2;
        int right = (n+m+2)/2;
        return (getKth(nums1,0,nums2,0,left)+getKth(nums1,0,nums2,0,right))/2.0;
    }
    private int getKth(int[] nums1,int s1,int[] nums2,int s2,int k)
    {
        int n = nums1.length, m=nums2.length;
        if(s1>=n) return nums2[s2+k-1];
        if(s2>=m) return nums1[s1+k-1];
        if(k==1)
        {
            return Math.min(nums1[s1],nums2[s2]);
        }
        int minVal1 = (s1+k/2-1>=n)? Integer.MAX_VALUE: nums1[s1+k/2-1];
        int minVal2 = (s2+k/2-1>=m)? Integer.MAX_VALUE: nums2[s2+k/2-1];
        if(minVal1<minVal2) return getKth(nums1,s1+k/2,nums2,s2,k-k/2);
        else return getKth(nums1,s1,nums2,s2+k/2,k-k/2);
    }
}