package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Chopin on 9/17/16.
 */
public class GetLeastKNumbers {
    public static void main(String args[]){
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.print(GetLeastNumbers_Solution(input,4));
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        if(k<=0||k>input.length){
            return result;
        }
        else{
            index = quickSelect(input, k, 0, input.length-1);
        }
        for(int i = 0; i <= index ; i++)
            result.add(Integer.valueOf(input[i]));

        return result;
    }
    public static int quickSelect(int[] input, int k, int start, int end){
        int index = start;
        if(start<end){
            int part = partition(input, start, end);
            if((part - start) == (k - 1))
                index = part;
            else if((part - start) > (k - 1))
                index = quickSelect(input, k, start, part - 1);
            else
                index = quickSelect(input, k-(part-start), part+1, end);
        }
        return index;
    }
    public static int partition(int[] input, int start, int end ){
        int tmp = input[start];
        while(start < end){
            while(start < end && input[end] >= tmp)
                end--;
            input[start] = input[end];
            while(start < end && input[start] < tmp)
                start++;
            input[end] = input[start];
        }
        input[start] = tmp;
        return start;
    }
}
