package LeetCode;

import java.util.ArrayList;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * @LeetCode 235
 */
public class LCAofBST {
    public static void main(String args[]){
        Object[] val = {5,3,6,2,4,null,1};
        TNode root = new TNode(5);
        root.left = new TNode(3);
        root.right = new TNode(6);
        root.left.left = new TNode(2);
        TNode p = new TNode(4);
        root.left.right = p;
        root.right.left=null;
        root.right.right=null;
        TNode q = new TNode(1);
        root.left.left = q;
        TNode result = lowestCommonAncestor(root, p, q);
        System.out.print(result.val);
        System.out.print(val.length);
//        TNode r = root;
//        for(int i = 0 ; i<val.length/2 ; i++){
//            TNode temp;
//            if(val[2*i+1]!=null){
//                temp = new TNode((Integer) val[2*i+1]);
//                r.left =temp ;
//            }
//            if(val[2*i+2]!=null){
//                temp = new TNode((Integer) val[2*i+2]);
//                r.right =temp ;
//            }
//        }
    }

    public static TNode lowestCommonAncestor(TNode root, TNode p, TNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
