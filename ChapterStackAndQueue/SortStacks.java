package ChapterStacksAndQueue;

import java.util.Stack;

public class SortStacks {
    static Stack<Integer> mainStack = new Stack<>();
    public static void main(String[] args) {
        pushValue(6);
        pushValue(8);
        pushValue(2);
        pushValue(7);
        pushValue(1);
        pushValue(3);

        System.out.print("Sorted Values are: ");
        while (!mainStack.isEmpty()){
            System.out.print(mainStack.pop() +" -> ");
        }

    }

    private static void pushValue(int val) {
        Stack<Integer> temp = new Stack<>();

        if(mainStack.isEmpty()){
            mainStack.push(val);
        }else{
            while (!mainStack.isEmpty() && mainStack.peek() < val){
                temp.push(mainStack.pop());
            }
            mainStack.push(val);
            while (!temp.isEmpty()){
                mainStack.push(temp.pop());
            }
        }
    }
}
