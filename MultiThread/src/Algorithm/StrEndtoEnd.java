package Algorithm;

import java.util.Arrays;

/**
 * Created by DELL on 2016/9/20.
 *  给一个字符串数组，判断其是否是首尾相连的
 */
public class StrEndtoEnd {
    public static void main(String args[]){
        String [] str = {"gj","jl","dg","ad","gg"};
        //System.out.println(judge("aa", "dd"));
        fun(str, 0);
    }

    public static void fun(String[] strs, int k){
        if(strs.length == k){
            System.out.println(Arrays.toString(strs));
            return;
        }
        else
            for(int i = k; i < strs.length ; i++){
                if(k==0){
                    swap(strs, k, i);
                    fun(strs,k+1);
                    swap(strs, k, i);
                }
                else if(k >= 0 && isMatch(strs[k-1],strs[i])){
                    swap(strs, k, i);
                    fun(strs,k+1);
                    swap(strs, k, i);
                }
            }
        return ;
    }

    public static void swap(String[] strs, int k , int i){
        String tmp = strs[k];
        strs[k] = strs[i];
        strs[i] = tmp;
    }

    public static boolean isMatch(String k , String i){
        if(k.charAt(k.length()-1) == i.charAt(0))
            return true;
        return false;
    }
}
