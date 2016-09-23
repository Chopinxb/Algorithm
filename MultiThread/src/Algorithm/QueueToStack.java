package Algorithm;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by DELL on 2016/9/21.
 */
public class QueueToStack {
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    public int pop(){
        if(!isEmpty()){
            queue1Toqueue2();
            return queue2.removeFirst();
        }
        return -1;
    }

    public void push(int element){
        queue1.add(element);
    }

    public void queue1Toqueue2(){
        while(queue1.size()>1)
            queue2.add(queue1.removeFirst());
        LinkedList<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public boolean isEmpty(){
        if(queue1.isEmpty()&&queue2.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        QueueToStack stack=new QueueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
