// 最简单的办法是(a+b).compareTo(b+a)作为新的判断方法 但是运行起来效率不理想
// 先按两个的最小长度进行比较，如果都相等，则a+b与b+a进行比较
class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return stringCompare(o2,o1);
            }
        };
        String[] s = new String[len];
        for(int i=0;i<len;i++)
        {
            s[i]=String.valueOf(nums[i]);
        }
        String ans="";
        Arrays.sort(s,comparator);
        for(int i=0;i<len;i++)
        {
            ans+=s[i];
        }
        if(Integer.valueOf(ans)==0) return "0";
        return ans;

    }
    private int stringCompare(String a,String b)
    {

        int min_len = Math.min(a.length(),b.length());
        for(int i=0;i<min_len;i++)
        {
            if(a.charAt(i)>b.charAt(i)) return 1;
            else if(a.charAt(i)<b.charAt(i)) return -1;
        }
        if(a.length()==b.length()) return 0;
        if((a+b).compareTo(b+a)>0) return 1;
        else if((a+b).compareTo(b+a)<0) return -1;
        else return 0;

    }
}