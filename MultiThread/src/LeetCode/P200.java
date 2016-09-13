package LeetCode;

/**
 * Created by DELL on 2016/9/8.
 */
public class P200 {
    public static void main(String args[]){
        int[][] a ={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int count = 0;
        int maxSize = 0;
        for(int i = 0 ; i<a.length ; i++){
            for(int j = 0 ; j<a[0].length; j++){
                if(a[i][j]==1){
                    count++;
                    int[] size = {0};
                    bfs(a,i,j,size);
                    if(size[0]>maxSize){
                        maxSize=size[0];
                    }
                }
            }
        }
        System.out.println("Total number of iland is "+count + ", MaxSize of those iland is " + maxSize);
    }

    public  static void bfs(int[][] a , int i, int j, int[] size){
        if(i<a.length&&i>=0&&j<a[0].length&&j>=0){
            if(a[i][j]==1){
                a[i][j]=0;
                size[0]++;
                if(i>0)bfs(a,i-1,j,size);
                if(j<a[0].length-1)bfs(a,i,j+1,size);
                if(i<a.length-1)bfs(a,i+1,j,size);
                if(j>0)bfs(a,i,j-1,size);
            }
        }
    }
}
