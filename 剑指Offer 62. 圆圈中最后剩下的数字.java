// 剑指Offer 62. 圆圈中最后剩下的数字
// 约瑟夫环问题 推导公式: f(n,m)=(f(n-1,m)+m)%n;
// 循环写法

class Solution {
    public int lastRemaining(int n, int m) {
        if(n==1) return 0;
        int value = 0;
        for(int i=1;i<=n;i++)
        {
            value=(value+m)%i;
        }
        return value;
    }
}

// 递归写法

class Solution {
    public int lastRemaining(int n, int m) {
        if(n==0||n==1) return 0;
        return (lastRemaining(n-1,m)+m)%n;
    }
}

// 普通写法
class Solution {
    public int lastRemaining(int n, int m) {
        if(n==0||n==1) return 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(i);
        }
        int index=0;
        while(list.size()>1)
        {
            index = (index+m-1)%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}