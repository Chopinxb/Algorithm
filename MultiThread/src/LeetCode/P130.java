package LeetCode;

/**
 * Created by DELL on 2016/9/8.
 */
public class P130 {
    public static void main(String args[]){
        char[][] a ={{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        int count = 0;
        int maxSize = 0;
        for(int i = 0 ; i<a.length ; i++){
            for(int j = 0 ; j<a[0].length; j++){
                if(a[i][j]=='o'){
                    boolean flag = false;//是否是边界
                    if(i==0||j==0)
                        flag=true;
                    count++;
                    int[] size = {0};
                    bfs(a,i,j,size,flag);
                    if(size[0]>maxSize){
                        maxSize=size[0];
                    }
                }
            }
        }
        System.out.println("Total number of iland is "+count + ", MaxSize of those iland is " + maxSize);
    }

    public  static void bfs(char[][] a , int i, int j, int[] size,boolean flag){
        if(i<a.length&&i>=0&&j<a[0].length&&j>=0){
            if(a[i][j]=='o'){
                if(!flag)
                    a[i][j]='x';
                else
                    a[i][j]='s';
                size[0]++;
                bfs(a,i,j+1,size,flag);
                bfs(a,i+1,j,size,flag);
                bfs(a,i,j-1,size,flag);
            }
        }
    }
}
