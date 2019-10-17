class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] num = new int[200];
        int st = 0;
        int re = 0;
        for (int i=0;i<s.length();i++)
        {
            if(num[s.charAt(i)-' ']!=0)
            {
                st = Math.max(st,num[s.charAt(i)-' ']);
            }
            int temp = i+1-st;
            re = Math.max(temp,re);
            num[s.charAt(i)-' '] = i+1;
        }
        return re;
    }
}