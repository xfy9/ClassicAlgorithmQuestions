class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int target1 = (nums1.length+nums2.length+1)/2;
        int target2 = (nums1.length+nums2.length+2)/2;
        int i=0,j=0,num=0;
        int ele1=0,ele2=0,renum=0; 
        double re;
        while(i<nums1.length&&j<nums2.length)
        {
            int temp;
            if(nums1[i]<nums2[j]) 
            {
                temp = nums1[i];
                i++;
            }
            else 
            {
                temp = nums2[j];
                j++;
            }   
            num++;
            if(num==target1) 
            {
                ele1 = temp;
                renum++;
            }
            if(num==target2) 
            {
                ele2 = temp;
                renum++;
            }
            //System.out.println("ele1="+ele1+" ele2="+ele2);
            
        }
        if(renum==2) return (ele1+ele2)*1.0/2;
        if(i<nums1.length)
        {
            if(renum==0) 
            {
                ele1 = nums1[i+target1-num-1];
                renum++;
            }
            if(renum==1) ele2 = nums1[i+target2-num-1];
            
        }
        if(j<nums2.length)
        {
            if(renum==0) 
            {
                ele1 = nums2[j+target1-num-1];
                renum++;
            }
            if(renum==1) ele2 = nums2[j+target2-num-1];
        }
        //System.out.println("ele1="+ele1+" ele2="+ele2);
        return (ele1+ele2)*1.0/2;
    }
}