package Algorithm;

import java.io.File;

/**
 * Created by DELL on 2016/9/21.
 */
public class ReverseLinkList {
    public static Node reverseLinkList(Node root){
        if(root == null)
            return root;
        Node newHead = new Node();
        newHead.next = null;
        Node tmp;
        while(root!=null){
            tmp = root.next;
            root.next = newHead.next;
            newHead.next = root;
            root = tmp;
        }
        return newHead.next;
    }
    private static Node createLine(int[] nums , Node root){
        int i=0;
        Node head = root;
        while (i<nums.length)
        {
            Node node = new Node();
            root.next = node;
            node.val = nums[i];
            node.next = null;
            root = node;
            i ++;

        }
        return head;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        Node root = createLine(nums,new Node());
        System.out.println("——————————————————链表顺序打印———————————————————");
        printLine(root);

        System.out.println("——————————————————链表逆置打印———————————————————");
        printLine(reverseLinkList(root));
    }
    private static void printLine(Node head){

        Node node = head;
        while(node!=null&&node.next!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
class Node{
    public Node next;
    public int val;
}