package ChapterLinkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDups {

    public static void display(Node n){
        while (n != null){
            System.out.print("Node Data: " + n.data +" ");
            n= n.next;
        }
    }

    public static void main(String args[]){

        Node inputNode = new Node(1);
        inputNode.appendToTail(2);
        inputNode.appendToTail(3);
        inputNode.appendToTail(2);
        inputNode.appendToTail(4);
        inputNode.appendToTail(3);
        inputNode.appendToTail(1);
        inputNode.appendToTail(5);
        inputNode.appendToTail(3);
        inputNode.appendToTail(6);
        System.out.println("Before Removing Duplicates");
        display(inputNode);
        //removeDupsApproach1(inputNode);       //Extra Space

        removeDupsApproach2(inputNode);         //No Space
        System.out.println("After Removing Duplicates");
        display(inputNode);
    }

    //No extra Space Time: O(n*n)
    private static Node removeDupsApproach2(Node inputNode) {
        if (inputNode == null) return inputNode;

        Node currNode = inputNode;
        Node prevNode = null;

        while (currNode != null){
            int currData = currNode.data;
            Node temp = currNode.next;

            while(temp != null){
                if(currData == temp.data){
                    prevNode.next = temp.next;
                }else {
                    prevNode = temp;
                }
                temp = temp.next;
            }
            currNode = currNode.next;
        }

        return inputNode;
    }

    //Using Extra Space and Time is O(n)
//    private static Node removeDupsApproach1(Node input) {
//        if(input == null) return input;
//
//        Set<Integer> data = new HashSet<>();
//        Node prev = null;
//
//        while(input!= null && input.next != null){
//            if(data.contains(input.data)){
//                prev.next = input.next;
//            }else{
//                data.add(input.data);
//                prev = input;
//            }
//            input = input.next;
//        }
//
//        return input;
//    }
}
