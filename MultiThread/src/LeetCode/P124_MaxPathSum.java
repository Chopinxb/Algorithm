package LeetCode;

/**
 * Created by Chopin on 2016/9/22.
 */
public class P124_MaxPathSum {
    private int maxValue;
    public int maxPathSum(TNode root){
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    public int maxPathDown(TNode node){
        if(node == null)
            return 0;
        int left = Math.max(0,maxPathDown(node.left));
        int right = Math.max(0,maxPathDown(node.right));
        maxValue = Math.max(maxValue , left+right+node.val);
        return Math.max(left,right)+node.val;
    }
}
