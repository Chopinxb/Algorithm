package Algorithm;

/**
 * Created by DELL on 2016/9/16.
 */
public class LeftRotateString {
    public static void main(String args[]){
        System.out.print(leftRotateString("",2));
    }

    public static String leftRotateString(String str, int n){
        if(str == null || str.trim().equals("")||n<0||n>str.length())
            return str;
        String[] strs = new String[2];
        strs[0] = str.substring(0,n);
        strs[1] = str.substring(n,str.length());
        StringBuilder result = new StringBuilder();
        for(int i = strs.length-1 ; i > 0 ; i--){
            result.append(strs[i]);
            result.append(" ");
        }
        result.append(strs[0]);
        return result.toString();
    }
}
