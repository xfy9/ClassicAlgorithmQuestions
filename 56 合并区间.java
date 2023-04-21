// 56 合并区间
// java 排序 比较器 new Comparator compare
// o1-o2 从小到大 o2-o1从大到小
// List转数组 ArrayList.toArray(new String[arr.size()]);
// 数组转List Arrays.asList(array);

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[][]{};
        Comparator<int[]> comparator  = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])
                {
                    return o1[0]-o2[0];
                }
                else return o1[1]-o2[1];
            }
        };
        Arrays.sort(intervals,comparator);
        ArrayList<int[]> arr = new ArrayList<>();
        int start = intervals[0][0],end = intervals[0][1];
        boolean flag = false;
        for(int i=1;i< intervals.length;i++)
        {
            if(end<intervals[i][0])
            {
                arr.add(new int[]{start,end});
                start=intervals[i][0];
                end = intervals[i][1];
            }
            else
            {
                if(end<intervals[i][1])
                    end = intervals[i][1];
            }
        }
        arr.add(new int[]{start,end});
        int[][] ans = arr.toArray(new int[arr.size()][]);
        return ans;


    }
}