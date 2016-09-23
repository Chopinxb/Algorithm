package Algorithm;

import java.util.Arrays;

/**
 * Created by DELL on 2016/9/23.
 */
public class Manacher {
    public static void main(String args[]){
        System.out.println(Arrays.toString(new Manacher().manacher("abccd")));
    }
    public int[] manacher(String s){
        int[] pArr = new int[s.length()*2+1];
        int pR = 0;
        int index = 0;
        //预处理
        StringBuilder newstr = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            newstr.append('#');
            newstr.append(s.charAt(i));
        }
        String str = newstr.append('#').toString();
        //遍历
        for(int i = 0 ; i < str.length() ; i++){
            //i在前一个index为中心得回文半径内
            if( i < pR){
                int r = pArr[2*index -i];
                //i关于index对称位置的回文串在index为中心回文串里面
                if(2*index-i-r < index - pArr[index]){
                    pArr[i] = r;
                }
                //i关于index对称位置的回文串超出index为中心回文串
                else if(2*index-i-r > index - pArr[index]){
                    pArr[i] = r;
                }
                //i关于index对称位置的回文串边界刚好等于index为中心回文串边界
                else{
                    int j=pR-i;
                    while(  i-j>=0 && i+j < pArr.length && str.charAt(i-j)==str.charAt(i+j)){
                        j++;
                    }
                    pR = i+j;
                    pArr[i] = j;
                    index = i;
                }
            }
            //暴力扩展
            else{
                int j=1;
                while(  i-j>=0 && i+j < pArr.length && str.charAt(i-j)==str.charAt(i+j)){
                    j++;
                }
                pR = i+j;
                pArr[i] = j;
                index = i;
            }
        }
//        int maxR = pArr[0];
//        for (int i = 0 ; i < pArr.length ; i++ ) {
//            if(pArr[i]>maxR)
//                maxR = pArr[i];
//        }
        return pArr;

    }
}
