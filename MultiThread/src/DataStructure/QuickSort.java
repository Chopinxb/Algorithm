package DataStructure;


import java.util.Arrays;


/**
 * Created by DELL on 2016/7/21.
 */
public class QuickSort {
    public static void main(String args[]){
        int[] testArray = {23,21,465,432,13,12,4,23,120};
        quickSort(testArray,0,testArray.length-1);
        System.out.print(Arrays.toString(testArray));

    }

    public static void quickSort(int[] testArray,int start,int end){
        if(start<end){
            int middle = getMiddle(testArray, start, end);
            quickSort(testArray,start,middle-1);
            quickSort(testArray,middle+1,end);
        }
    }

    public static int getMiddle(int[] testArray, int start,int end){
        int pivot = testArray[start+(int)Math.random()/(end-start)];
        while(start<end) {
            while (start < end && testArray[end] >= pivot)
                end--;
            testArray[start] = testArray[end];
            while (start < end && testArray[start] < pivot)
                start++;
            testArray[end] = testArray[start];

        }
        testArray[start] =pivot;
        return start;
    }
}
