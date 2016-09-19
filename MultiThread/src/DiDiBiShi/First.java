package DiDiBiShi;

/**
 * Created by Chopin on 9/18/16.
 * 青蛙一定体力p过迷宫a[n][m],输出消耗最少体力的路径
 */
import java.util.ArrayList;
import java.util.Scanner;
public class First {
    private static ArrayList<Integer> result = new ArrayList<>();
    private static boolean flag;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            result.clear();
            flag = false;
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            int[][] a = new int[n][m];
            for(int i = 0 ; i < n ; i++ ){
                for(int j = 0 ; j < m ; j++){
                    a[i][j] = in.nextInt();
                }
            }
            ArrayList<Integer> path = new ArrayList<>();
            int[] minPath  = {p};
            bfs(a,0,0,path,0,minPath);
            if(!flag){
                System.out.println("Can not escape!");
            }
            else{
                System.out.print("[0,0]");
                int i=0, j=0;
                for(Integer s : result){
                    if(s==0){
                        i--;
                        System.out.print(",["+i+","+j+"]");
                    }
                    if(s==1){
                        j++;
                        System.out.print(",["+i+","+j+"]");
                    }
                    if(s==2){
                        i++;
                        System.out.print(",["+i+","+j+"]");
                    }
                    if(s==3){
                        j--;
                        System.out.print(",["+i+","+j+"]");
                    }

                }
            }
        }
    }

    public static void bfs(int[][] a ,int i , int j, ArrayList<Integer> path , int p ,int[] minPath ){
        //上
        if(i == 0 && j == a[0].length-1){
            flag = true;
            if(minPath[0] > p){
                result.clear();
                result.addAll(path);
                minPath[0]= p;
            }
        }
        if(i<a.length-1)
            if(a[i+1][j]==1 && p<minPath[0]) {
                path.add(2);
                bfs(a, i + 1, j, path, p, minPath);
                path.remove(path.size()-1);
            }
        if(j<a[0].length-1)
            if(a[i][j+1]==1 && p+1<minPath[0]) {
                path.add(1);
                bfs(a,i,j+1 ,path,p+1, minPath);
                path.remove(path.size()-1);
            }
        if(j>0)
            if(a[i][j-1]==1 &&p+1<minPath[0]){
                path.add(3);
                bfs(a,i,j-1,path,p+1, minPath);
                path.remove(path.size()-1);
            }
        if(i>0)
            if(a[i-1][j]==1 && p+3<minPath[0]){
                path.add(0);
                bfs(a,i-1,j,path,p+3, minPath);
                path.remove(path.size()-1);
            }
    }
}
