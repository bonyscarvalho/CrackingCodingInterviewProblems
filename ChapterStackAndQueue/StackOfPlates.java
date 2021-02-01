package ChapterStacksAndQueue;

import java.util.Stack;

public class StackOfPlates {

    static Stack<Stack<Integer>> mainStack = new Stack<>();
    static Stack<Integer> stack = new Stack<>();
    static int sizeCount = 3;

    public static void main(String[] args) {

     mainStack.push(stack);
     pushValues(1);
     pushValues(2);
     pushValues(3);
     pushValues(4);
     pushValues(5);
     pushValues(6);
     pushValues(7);
     pushValues(8);
     pushValues(9);
     pushValues(10);
     pushValues(11);

     System.out.println("Main Stack Size: " + mainStack.size());

//     System.out.println("Popped Values: " + popValues() + " " + popValues());
//     System.out.println("Afer Popped Size: " + mainStack.size());

     System.out.println("Pop at Index-2 : " + popValuesAtIndex(2));
     System.out.println("Pop at Index-1: " + popValuesAtIndex(1));


    }

    private static void pushValues(int val) {
        stack = mainStack.pop();
        if(stack.size() == sizeCount){
            System.out.println("New Stack" + val);
            mainStack.push(stack);
            stack = new Stack<>();
        }
        stack.push(val);
        mainStack.push(stack);
    }

    private static int popValues() {
        stack = mainStack.peek();
        int poppedNum = stack.pop();
        if(stack.size() == 0){
            mainStack.pop();
        }
        return poppedNum;
    }

    //there is a trade off here. If you remove a value from a particular Index then you have to move 
    // the last(bottom) val from next stack to current one and so on till the last stack in the mainStacks
    private static int popValuesAtIndex(int index) {
        int popValue = -1;
        if(mainStack.size() - 1 == index){
            return mainStack.peek().pop();
        }else{
            stack = mainStack.pop();
            popValue = popValuesAtIndex(index);
            mainStack.push(stack);
        }
        return popValue;
    }


}
