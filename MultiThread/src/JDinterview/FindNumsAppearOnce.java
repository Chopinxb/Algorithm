package JDinterview;

/**
 * Created by Chopinxb on 2016/9/13.
 * find the numbers that just appear once;
 */
public class FindNumsAppearOnce {
    public static void main(String args[]){
        int[] a = {1,1,2,3,3,4,4,5,5,6};
        int[] nums1 = {0};
        int[] nums2 = {0};
        findNumsAppearOnce(a, nums1, nums2);
        System.out.println(nums1[0]);
        System.out.println(nums2[0]);
    }
    public static void findNumsAppearOnce(int[] data , int[] nums1 , int[] nums2){
        int resultExclusiveOR=data[0];
        for(int i = 1; i < data.length; i++){
            resultExclusiveOR ^= data[i];
        }
        int first1Index = firstBitIs1(resultExclusiveOR);

        for(int i = 0; i < data.length; i++){
            if(isBit1(data[i], first1Index)){
                nums1[0] ^= data[i];
            }
            else
                nums2[0] ^= data[i];
        }
    }
    public static int firstBitIs1(int num){
        int index = 0;
        while((num & 1) == 0){
            num = num >> 1;
            index++;
        }
        return index;
    }
    public static boolean isBit1(int data, int index){
        data >>= index ;
        return (data & 1) == 1;
    }

}
