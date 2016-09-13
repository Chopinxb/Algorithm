package DataStructure;

import java.util.Arrays;

/**
 * Created by DELL on 2016/7/21.
 */
public class HeapSort {
    public static void main(String args[]){
        int[] testArray = {23,21,465,432,12,4,23,120};
        heapSort(testArray,testArray.length);
        System.out.print(Arrays.toString(testArray));
    }
    public static void heapSort(int[] testArray,int length){
        //重排数组
        makeHeap(testArray,length);
        System.out.println(Arrays.toString(testArray));
        int unsorted = length;
        while(unsorted>1){
            unsorted--;
            int temp = testArray[0];
            testArray[0] = testArray[unsorted];
            testArray[unsorted]=temp;
            reHeapifyDown(testArray,unsorted);
            System.out.println(Arrays.toString(testArray)+"unsorted:"+unsorted);
        }
    }
    private static void makeHeap(int[] data, int n){
        for(int i=0;i<n/2;i++){
            int current = i;
            Boolean heapOk = false;
            int parent = (i-1)/2;
            while((!heapOk)&&parent>=0){
                if(data[current]>data[parent]){
                    int temp = data[current];
                    data[current] = data[parent];
                    data[parent] =temp;
                    current = parent;
                    parent = (current-1)/2;
                }
                else
                    heapOk = true;
            }
        }
    }

    private static void reHeapifyDown(int[] data , int n){
        int unsafeNodeId = 0;
        int bigChildIndex;
        int leftChild = unsafeNodeId*2+1;
        int rightChild = unsafeNodeId*2+2;
        Boolean heapOk = false;
        while((!heapOk)&&leftChild<n) {
            bigChildIndex = leftChild;
            if (rightChild < n && data[leftChild] < data[rightChild]) {
                bigChildIndex = rightChild;
            }

            if (data[unsafeNodeId] < data[bigChildIndex]) {
                int temp = data[unsafeNodeId];
                data[unsafeNodeId] = data[bigChildIndex];
                data[bigChildIndex] = temp;
                unsafeNodeId = bigChildIndex;
                leftChild = unsafeNodeId*2+1;
                rightChild = unsafeNodeId*2+2;
            }
            else{
                heapOk = true;
            }
        }
    }
}
