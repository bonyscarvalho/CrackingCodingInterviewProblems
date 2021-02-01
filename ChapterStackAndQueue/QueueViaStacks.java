package ChapterStacksAndQueue;

import java.util.Stack;

public class QueueViaStacks {
    public static void main(String[] args) {
        Stack<Integer> mainStack = new Stack<>();

        pushValues(1, mainStack);
        pushValues(2, mainStack);
        pushValues(3, mainStack);
        pushValues(4, mainStack);

        System.out.print("Queue is: ");
        while (!mainStack.isEmpty()){
            System.out.print(mainStack.pop() +" -> ");
        }

    }

    private static void pushValues(int val, Stack<Integer> mainStack) {
        Stack<Integer> temp = new Stack<>();
        if(mainStack.isEmpty()){
            mainStack.push(val);
        }else{
            while(!mainStack.isEmpty()){
                temp.push(mainStack.pop());
            }
            mainStack.push(val);
            while(!temp.isEmpty()){
                mainStack.push(temp.pop());
            }
        }
    }
}
