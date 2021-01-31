package ChapterStacksAndQueue;

import java.util.PriorityQueue;
import java.util.Stack;

public class StackMin {
    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> minValueStack = new Stack<>();

    //static PriorityQueue<Integer> minValues = new PriorityQueue<>();

    public static void main(String[] args) {
        pushValue(6);
        pushValue(8);
        pushValue(2);
        pushValue(7);
        pushValue(1);
        pushValue(3);
        System.out.println("Min Value: " + popValue());
        System.out.println("Min Value: " + popValue());
        System.out.println("Min Value: " + popValue());
//        int min = minValues.poll();
//        System.out.println("Min Value: " +min);
//        min = minValues.poll();
//        System.out.println("Min Value: " +min);

    }

    private static int popValue() {
        int popedVal = minValueStack.pop();
        if(popedVal == minValue()){
            minValueStack.pop();
        }
        return popedVal;
    }

    private static void pushValue(int val) {
        if(val <= minValue()){
            minValueStack.push(val);
        }
        mainStack.push(val);
    }

    private static int minValue() {
        if(minValueStack.isEmpty()) return Integer.MAX_VALUE;
        return minValueStack.peek();
    }

//    private static void pushValue(int val) {
//        stack.push(val);
//        minValues.add(val);
//    }
}
