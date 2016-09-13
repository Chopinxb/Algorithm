package DataStructure;

import java.util.Arrays;

/**
 * Created by DELL on 2016/9/8.
 */
public class BinarySearch {
    public static void main(String args[]) {
        int[] a = {2, 3, 5, 6, 7, 43, 67};
        int searchnum = 67;
        long startTime = System.currentTimeMillis();
        int start = 0;
        int end = a.length-1;
        int i;
        int result=-1;

        do {
            i= (end+start)/ 2;
            if(a[i]==searchnum){
                result = i;
                break;
            }
            else if(a[i]<searchnum){
                start = i+1;
            }
            else
                end = i-1;
        } while (i != 1 && i != a.length);

        if(result!=-1)
            System.out.println(result);
        else
            System.out.println(-1);
//        System.out.println(System.currentTimeMillis()-start);
//        startTime= System.currentTimeMillis();
        System.out.println(binarySearch(a,0,a.length-1,searchnum));
//        System.out.println(System.currentTimeMillis()-start);
        System.out.println(Arrays.binarySearch(a,0,a.length,searchnum));
        Math.pow(12,12);
    }

    public static int binarySearch(int[] a , int start ,int end,int searchNum){
        if(start<=end){
            int mid = (end + start)/2;
            if(a[mid]==searchNum)
                return mid;
            else if(a[mid]<searchNum)
                return binarySearch(a,mid+1,end , searchNum);
            else
                return binarySearch(a,start,mid-1,searchNum);
        }
        else
            return -1;
    }


}
