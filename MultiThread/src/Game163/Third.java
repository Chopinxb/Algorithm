package Game163;

import java.util.*;

/**
 *  Created by Chopin on 9/19/16.
 *  有m种礼物,每种礼物的价格为Vi,给主播加的魅力值为Pi,土豪有n游戏币,主播希望土豪的送礼次数不少于l次,求将游戏币花完的最小次数,
 *  并且尽可能使得主播的魅力值增加的最多.
 */
public class Third {
    private static int t ;
    private static int p  ;
    private static int l;
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n,  m;
        while(cin.hasNextInt())
        {
            t = Integer.MAX_VALUE;
            p = 0;
            n = cin.nextInt();
            l = cin.nextInt();
            m = cin.nextInt();
            int[] a = new int[m];
            HashMap<Integer , Integer>  map = new HashMap<>();
            for(int i = 0 ; i < m ; i++){
                int key = cin.nextInt();
                a[i] = key ;
                map.put(key,cin.nextInt());
            }
            Arrays.sort(a);
            findMinPath(a,0,n,0,map);
            System.out.println( t +" "+p );
        }
    }
    public static void findMinPath(int[] a, int count , int remain , int meili, HashMap<Integer , Integer>  map){
        int i = a.length-1;
        if(remain == 0){
            if(count<l)
                return;
            if(t > count){
                p = meili;
                t =count;
            }
            else if( t==count){
                if(p<meili){
                    p = meili;
                }
            }
        }
        if(count>t)
            return;
        while(i>=0){
            if(remain-a[i]>=0){
                findMinPath(a, count+1 , remain-a[i], meili+map.get(a[i]),map);
            }
            i--;
        }
    }
}

