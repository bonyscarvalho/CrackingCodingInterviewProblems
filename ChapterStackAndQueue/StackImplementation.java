package ChapterStacksAndQueue;

public class StackImplementation {
    static int[] orgArray = new int[6];
    static int numOfStacks = 3;
    static int[] nextValue = new int[orgArray.length];
    static int[] tops = new int[numOfStacks];
    static int availableSpace = 0;

    public static void main(String[] args) {
        for(int top = 0; top < tops.length; top++){
            tops[top] = -1;
        }
//        System.out.println("TOPS VALUE");
//        for (int top : tops){
//            System.out.println("Top "+ top);
//        }
        System.out.println("Next VALUE");
        for (int i = 0; i < nextValue.length - 1; i++){
            nextValue[i] = i + 1;
        }
        nextValue[nextValue.length - 1] = -1;

        orgArray = computeStackWithArray(orgArray);
        for (int arr : orgArray){
            System.out.println("Values in Arrays are: " +arr);
        }
        System.out.println("TOPS VALUE");
        for (int top : tops){
            System.out.println("Top "+ top);
        }


        for (int next : nextValue){
            System.out.println("Next Index "+ next);
        }
    }

    private static int[] computeStackWithArray(int[] orgArray) {
        push(100, 2);
        push(200, 0);
        push(300, 2);
        push(400, 2);
        push(500, 2);
        push(600, 0);
       // push(700, 0);

        popValueFromStack(1);



        return orgArray;
    }

    private static void popValueFromStack(int stackNum) {
        if (isEmpty(stackNum))
        {
            System.out.println("Stack Underflow");
            return;
        }
        int stackNumberToRemoveItem = stackNum;
        int popedValue = orgArray[tops[stackNumberToRemoveItem]];
        int topIdx = tops[stackNum];
        System.out.println("Poped Value: " + popedValue);

        orgArray[topIdx] = -1;
        tops[stackNum] = nextValue[topIdx];
        System.out.println("Top Value for " + stackNum + " is " + topIdx);
        nextValue[topIdx] = -1;

        availableSpace = topIdx;
        System.out.println("Avaiable Space is " + availableSpace);

        //orgArray[tops[stackNumberToRemoveItem]] = -1;
    }

    private static boolean isEmpty(int stackNum) {
        return (tops[stackNum] == -1);
    }

    private static void push(int value, int stackNum) {
        if (isFull())
        {
            System.out.println("Stack Overflow");
            return;
        }
        orgArray[availableSpace] = value;
        if(tops[stackNum] != -1){
            nextValue[availableSpace] = tops[stackNum];
            tops[stackNum] = availableSpace;
        }else{
            tops[stackNum] = availableSpace;
            nextValue[availableSpace] = -1;
        }
        availableSpace++;

    }

    private static boolean isFull() {
        return (availableSpace == -1);
    }

}
