package LeetCode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * Created by DELL on 2016/8/8.
 * @LeetCode 198
 *
 * Problem details:
 *  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 *  stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 *  connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 *  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 *  of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public static void main(String args[]){
        int[] nums = {1,1,1};
        System.out.print(rob2(nums));
    }
    public int rob(int[] nums){
        if(nums.length<1){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int[] b = new int[nums.length];
        int[] s = new int[nums.length];
        b[0] = 1;
        s[0] = nums[0];
        s[1] = Math.max(s[0],nums[1]);
        for(int i = 2; i<nums.length ;i++){
            s[i] = Math.max(s[i-2]+nums[i],s[i-1]);
        }
        return s[nums.length-1];
    }

    /**
     * House Robber 2
     *first house and the last house are neighbor;
     *
     */
    public static int rob2(int[] nums){
        if(nums.length<1){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int[] b = new int[2];

        for(int start = 0 ; start < 2 ; start++){
            int n = nums.length;
            if (start == 0){
                n = nums.length - 1;
            }
            int[] s = new int[n];
            s[start] = nums[start];
            s[start+1] = Math.max(s[start],nums[start+1]);
            int i = start+2;
            for(; i<n ;i++){
                s[i] = Math.max(s[i-2]+nums[i],s[i-1]);
            }
            b[start] = s[i-1];
        }
        return b[0]>b[1]?b[0]:b[1];
    }

    /**
     * House Robber 3
     * @LeetCode 337
     *
     * Problem details:
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
     * called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart
     * thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if
     * two directly-linked houses were broken into on the same night.
     * Determine the maximum amount of money the thief can rob tonight without alerting the police.
     *
     */
    public int rob3(TNode root){
        if(root==null)return 0;
        int left=rob3(root.left);
        int right=rob3(root.right);
        int v=left+right;
        int s=root.val;
        if(root.left!=null) {
            s+=root.left.left==null?0:root.left.left.val;
            s+=root.left.right==null?0:root.left.right.val;
        }
        if(root.right!=null){
            s+=root.right.left==null?0:root.right.left.val;
            s+=root.right.right==null?0:root.right.right.val;
        }
        root.val=Math.max(s,v);
        return root.val;
    }
}

class TNode{
    int val;
    TNode left;
    TNode right;
    TNode(int x){val = x;}
}
