package Algorithm;

import java.math.BigInteger;

/**
 * Created by DELL on 2016/7/22.
 */
public class Gcd {
    public static void main(String args[]){
        BigInteger a = BigInteger.valueOf(324536454);
        BigInteger b = new BigInteger("31241241212");
        System.out.println(gcd(a,b));

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
}
