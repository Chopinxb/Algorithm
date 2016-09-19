package LeGoBiShi;

/**
 * Created by Chopin on 9/19/16.
 * 一只蚱蜢在起点0处,可以向前和向后跳,第一次跳一个单位,然后下一次跳的距离是上次的距离加1,问到位置n最少需要跳几次
 */

import java.util.Scanner;
public class Second {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int input = in.nextInt();
            System.out.println(jumpTimes(input));
        }
    }
    public static int jumpTimes(int num){
        int sum = 0 , count = 0;
        while(sum < Math.abs(num) || (sum - Math.abs(num)) % 2 == 1){
            count++;
            sum = sum + count;
        }
        return count ;
    }
}