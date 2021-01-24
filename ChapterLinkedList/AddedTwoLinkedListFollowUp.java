package ChapterLinkedList;

import java.util.Stack;

public class SumListNodeFollowUp {
    static class WrapperSum{
        public Node partialSum = null;
        public int carry = 0;
    }

    public static void display(Node n){
        while (n != null){
            System.out.print("Node Data: " + n.data +" ");
            n= n.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        Node inputNode1 = new Node(1);
        inputNode1.appendToTail(2);
        inputNode1.appendToTail(3);
        inputNode1.appendToTail(4);

        Node inputNode2 = new Node(5);
        inputNode2.appendToTail(6);
        inputNode2.appendToTail(7);
        inputNode2.appendToTail(8);

        System.out.println("Orginal Linked List Node 1");
        display(inputNode1);
        System.out.println("Orginal Linked List Node 2");
        display(inputNode2);
//        int len1 = lenOfNode(inputNode1);
//        int len2 = lenOfNode(inputNode2);
//        if(len1 < len2){
//            inputNode1 = paddListWithZero(inputNode1, len2 - len1);
//        }else if(len1 > len2){
//            inputNode2 = paddListWithZero(inputNode2, len1 - len2);
//        }
//        WrapperSum resultNode = addTwoLinkedListNodeRecursiveApproach(inputNode1, inputNode2);
//
//        if(resultNode.carry == 1){
//            Node carryNode = insertAHead(resultNode.partialSum,1);
//        }
        Node resultNode = addTwoLinkedListNodeIterativeApproach(inputNode1, inputNode2);
        //display(resultNode);
        //System.out.println("Addition of 2 Nodes" + resultNode);
        //display(resultNode.partialSum);
    }

    private static WrapperSum addTwoLinkedListNodeRecursiveApproach(Node inputNode1, Node inputNode2) {
        if(inputNode1 == null && inputNode2 == null){
            WrapperSum sum = new WrapperSum();
            return sum;
        }
        WrapperSum result = addTwoLinkedListNodeRecursiveApproach(inputNode1.next, inputNode2.next);

        int val = inputNode1.data + inputNode2.data + result.carry;
        System.out.println("Sum of 2 :" + val);

        Node sumNode = insertAHead(result.partialSum, val % 10);

        result.partialSum = sumNode;
        result.carry =val/10;

        return result;
    }

    private static Node paddListWithZero(Node inputNode, int noOfZeroPad) {
        Node head = inputNode;
        for(int i = 0; i < noOfZeroPad; i++){
            head = insertAHead(head, 0);
        }
        return head;
    }

    private static Node insertAHead(Node head, int value) {
        Node tempNode = new Node(value);

        if(head != null){
            tempNode.next = head;
        }
        return head;
    }

    private static int lenOfNode(Node currNode) {
        int len = 0;

        while(currNode != null){
            currNode = currNode.next;
            len++;
        }
        return len;
    }

    private static Node addTwoLinkedListNodeIterativeApproach(Node inputNode1, Node inputNode2) {
        if(inputNode1 == null) return inputNode2;
        if(inputNode2 == null) return inputNode1;
        Node currNode1 = inputNode1;
        Node currNode2 = inputNode2;

        Node result = null;
        int carry = 0;
        Stack<Integer> node1 = new Stack<>();
        Stack<Integer> node2 = new Stack<>();

        while (currNode1 != null){
            node1.push(currNode1.data);
            currNode1 = currNode1.next;
        }
        while (currNode2 != null){
            node2.push(currNode2.data);
            currNode2 = currNode2.next;
        }

        int minLen = Math.min(node1.size(), node2.size());

        int i = 0;
        while (i < minLen){
            int sum = node1.pop() + node2.pop() + carry;
            Node sumNode = new Node(sum % 10);
            sumNode.next = result;
            result = sumNode;

            carry = sum >= 10 ? 1 : 0;
            i++;
        }
        if(carry == 1){
            result = insertAHead(result, 1);
        }

        display(result);
        return result;
    }
}
