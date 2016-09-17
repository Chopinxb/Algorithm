package Algorithm;

/**
 * Created by DELL on 2016/9/16.
 */
public class ReverseSentence {
    public static void main(String args[]){
        System.out.print(reverseSentence(""));
    }

    public static String reverseSentence(String str){
        if(str == null || str.trim().equals(""))
            return str;
        String[] strs = str.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = strs.length-1 ; i > 0 ; i--){
            result.append(strs[i]);
            result.append(" ");
        }
        result.append(strs[0]);
        return result.toString();
    }
}
