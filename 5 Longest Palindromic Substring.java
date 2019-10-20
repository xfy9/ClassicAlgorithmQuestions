class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        int[][]dp = new int [1005][1005];
        int len = 1,st=0;
        for (int i=0;i<s.length();i++) dp[i][i] =1;
        for (int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=1;
                st=i;
                len=2;
            }
        }
        for (int i=3;i<=s.length();i++)
        {
            for (int j=0;i+j-1<s.length();j++)
            {
                if(dp[j+1][i+j-2]==1&&s.charAt(j)==s.charAt(i+j-1))
                {
                    dp[j][i+j-1]=1;
                    len = i;
                    st = j;
                }
            }
        }
        return s.substring(st,st+len);
    }
}