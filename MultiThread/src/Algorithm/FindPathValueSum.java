package Algorithm;

import java.util.ArrayList;

/**
 * Created by Chopin on 9/14/16.
 * Solution:
 * use preorder traversal binary tree.
 */
public class FindPathValueSum {

    public ArrayList<ArrayList<Integer>> findPaths(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] sum = new int[1];
        findPath(resultList, result, root, target, sum);
        return resultList;

    }
    public void findPath(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> temResult,
                                                  TreeNode root, int target, int[] sum){
        if(root == null)
            return;
        int temp = sum[0] + root.val;
        if(temp == target) {
            ArrayList<Integer> result = (ArrayList<Integer>) temResult.clone();
            result.add(root.val);
            resultList.add(result);
        }
        if(temp < target){
            temResult.add(root.val);
            sum[0] = temp;
            findPath(resultList, temResult, root.left, target, sum);
            findPath(resultList, temResult, root.right, target, sum);
            temResult.remove(temResult.size()-1);
            sum[0] = temp - root.val;
        }
        return ;
    }
    public
    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

}
