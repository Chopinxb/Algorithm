package Game163;

/**
 * Created by Chopin on 9/19/16.
 * 求一个数的最大公约数和最小公倍数
 */

import java.util.*;
import java.math.BigInteger;
public class First {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext())
        {
            String[] s = cin.nextLine().split(" ");
            BigInteger a = new BigInteger(s[0]);
            BigInteger b = new BigInteger(s[1]);
            BigInteger c = gcd(a,b);
            BigInteger d = min(a,b,c);
            System.out.println(c+" "+d);
        }
    }
    private static BigInteger gcd(BigInteger x, BigInteger y){
        if(x.compareTo(y)<0){
            return gcd(y,x);
        }
        if(y==BigInteger.ZERO)
            return x;
        else
            return gcd(x.subtract(y),y);
    }
    private static BigInteger min( BigInteger x, BigInteger y, BigInteger c){
        BigInteger tmp1 =  x.divide(c);
        BigInteger tmp2 =  y.divide(c);
        BigInteger tmp3 = tmp1.multiply(tmp2);
        return c.multiply(tmp3);
    }
}
