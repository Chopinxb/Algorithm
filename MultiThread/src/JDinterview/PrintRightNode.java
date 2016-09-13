package JDinterview;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by DELL on 2016/9/13.
 */
public class PrintRightNode {
    public static void main(String args[]){
        TNode root=null;
//        TNode root = new PrintRightNode().new TNode(1);
//        root.leftNode = new PrintRightNode().new TNode(2);
//        root.rightNode = new PrintRightNode().new TNode(3);

//        TNode p = root.leftNode;
//        p.leftNode = new PrintRightNode().new TNode(4);
//        p.rightNode = new PrintRightNode().new TNode(5);
//        p = p.rightNode;
//        p.leftNode = new PrintRightNode().new TNode(7);
//        p = p.leftNode;
//        p.leftNode = new PrintRightNode().new TNode(9);
//
//        TNode q= root.rightNode;
//        q.leftNode = new PrintRightNode().new TNode(6);
//        q = q.leftNode;
//        q.rightNode = new PrintRightNode().new TNode(8);

        printRightNode(root);

    }

    public static void printRightNode(TNode root){
        Queue<TNode> nodeQueue = new LinkedBlockingQueue<>();
        Queue<Integer> valueQueue = new LinkedBlockingQueue<>();

        int level=1;
        if(root==null){
            return ;
        }
        else{
            nodeQueue.add(root);
            valueQueue.add(level);
        }
        while(!nodeQueue.isEmpty()){
            TNode parent = nodeQueue.poll();
            int curLevel = valueQueue.poll();
            if(nodeQueue.isEmpty()||curLevel!=valueQueue.peek())
                System.out.println(parent.value);
            if(parent.leftNode!=null){
                nodeQueue.add(parent.leftNode);
                valueQueue.add(curLevel+1);
            }
            if(parent.rightNode!=null){
                nodeQueue.add(parent.rightNode);
                valueQueue.add(curLevel+1);
            }

        }

    }

    class TNode{
        int value;
        TNode leftNode;
        TNode rightNode;
        public TNode(int value){
            this.value = value;
        }
    }
}
