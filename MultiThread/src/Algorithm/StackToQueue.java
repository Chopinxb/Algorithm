package Algorithm;

import java.util.Stack;

/**
 * Created by DELL on 2016/9/21.
 */
public class StackToQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void add(int element){
        stack1.push(element);
    }
    public int deQueue(){
        if(size() != 0){
            if(stack2.empty())
                stack1ToStack2();
            return stack2.pop();
        }
        else
            return -1;
    }
    public void stack1ToStack2(){
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
    public int size(){
        return stack1.size()+stack2.size();
    }
    public static void main(String args[]){
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.add(1);
        stackToQueue.add(2);
        stackToQueue.add(3);
        stackToQueue.add(4);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        stackToQueue.add(5);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
    }

}
