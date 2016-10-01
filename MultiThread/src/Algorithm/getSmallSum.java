package Algorithm;

/**
 *
 * Created by Chopin on 2016/10/01.
 * 现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。
 * 请设计一个高效算法，计算数组的单调和。
 * 给定一个数组A同时给定数组的大小n，请返回数组的单调和。保证数组大小小于等于500，同时保证单调和不会超过int范围。
 */

public class getSmallSum {
    public int calcMonoSum(int[] a, int n) {
        // write code here
        if(a == null || a.length == 0)
            return 0;
        else
            return fun(a, 0 , a.length-1);
    }
    public int fun(int[] a, int start, int end){
        if(start>=end)
            return 0;
        else{
            int mid = (start+end)/2;
            return fun(a, start, mid) + fun(a, mid+1, end) + merge(a, start, mid ,end);
        }

    }
    public int merge(int[] a, int start, int mid, int end ){
        int[] h = new int[end - start + 1];
        int sum = 0;
        int index = 0;
        int i = start;
        int j = mid+1;
        while(i<=mid && j<= end){
            if(a[i] <= a[j]){
                sum += a[i]*(end - j +1);
                h[index++] = a[i++];
            }
            else{
                h[index++] = a[j++];
            }
        }
        for(; j <= end || i <= mid ; j++, i++){
            h[index++] =  j<=end ? a[j] : a[i];
        }
        for( i = 0; i < h.length ; i++){
            a[start++] = h[i];
        }
        return sum;
    }
}