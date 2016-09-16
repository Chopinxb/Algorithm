package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Chopin on 9/14/16.
 */
public class StringPermutation {
    private static ArrayList<String> results = new ArrayList<>();

    public static void main(String args[]){
        String str = "aabc";
        permutation(str);
        System.out.println(results);
    }
    public static ArrayList<String> permutation(String str) {
        if(str==null||str.length()==0)
            return results ;
        else
            permutation(str.toCharArray() , 0);
        Collections.sort(results);
        return results;
    }

    public static void permutation(char[] cs , int index){
        if(index == cs.length - 1) { //解空间的一个叶节点
            results.add(String.valueOf(cs)); //找到一个解
        } else {
            for(int j = index; j < cs.length; ++j) {
                if(j == index || cs[j] != cs[index]) {
                    swap(cs, index, j);
                    permutation(cs, index + 1);
                    swap(cs, index, j); //复位
                }
            }
        }

    }
    public static void swap(char[] cs , int i , int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] =temp;
    }
}
