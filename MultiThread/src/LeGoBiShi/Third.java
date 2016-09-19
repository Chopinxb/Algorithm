package LeGoBiShi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Chopin on 9/19/16.
 * 给定一个整数n,任意调换这个整数中的数字的位置,问给出的m是否是最小的调整后的整数
 */
public class Third {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(isMatch(n, m));
        }
        sc.close();
    }

    public static String isMatch(int n, int m) {
        String result = "NO";
        String strN = String.valueOf(n);
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < strN.length(); i++) {
            arr.add(strN.charAt(i));
        }
        Collections.sort(arr);

        int index = 0;
        while (arr.get(index) == '0') {
            index++;
        }
        if (index != 0) {
            arr.set(0, arr.get(index));
            arr.set(index, '0');
        }

        String out = "";
        for (int i = 0; i < arr.size(); i++) {
            out += arr.get(i);
        }
        if (Integer.parseInt(out) == m) {
            result = "YES";
        }

        return result;
    }

}
