package ChapterLinkedList;

public class PartitionByValue {
    public static void display(Node n){
        while (n != null){
            System.out.print("Node Data: " + n.data +" ");
            n= n.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        Node inputNode = new Node(3);
        inputNode.appendToTail(5);
        inputNode.appendToTail(8);
        inputNode.appendToTail(5);
        inputNode.appendToTail(10);
        inputNode.appendToTail(2);
        inputNode.appendToTail(1);
        System.out.println("Orginal Linked List");
        //display(inputNode);
        //inputNode = partitionByValueApproach1(inputNode, 5);

        inputNode = partitionByValueApproach2(inputNode, 5);
        System.out.println("After the Partition by Value is done");
        display(inputNode);
    }

    private static Node partitionByValueApproach2(Node inputNode, int x) {
        Node head = inputNode;
        Node tail = inputNode;
        System.out.println("Initial Value " + head.data +" "+ tail.data);

        while(inputNode != null){
            Node nextNode = inputNode.next;

            if(inputNode.data < x){
//                System.out.println("Head Input Node Next Value " + inputNode.next.data);
//                System.out.println("Head Input value " + inputNode.data);
                inputNode.next = head;
                head = inputNode;
                System.out.println("Head Value " + head.data);
            }else{
//                System.out.println("Tail Input Node Next Value " + tail.next.data);
                tail.next = inputNode;
//                System.out.println("AFter Tail Input Node Next Value " + tail.next.data);
                tail = inputNode;
                System.out.println("Tail Value " + tail.data);
            }

            inputNode = nextNode;
        }
        tail.next = null;

        return head;
    }

    private static Node partitionByValueApproach1(Node inputNode, int x) {
        if(inputNode == null) return inputNode;
        Node greaterEqualX = new Node(-1);
        Node prev = null;
        Node currNode = inputNode;
        Node attachedNode = greaterEqualX;

        while (currNode != null){
            if(currNode.data >= x){
                greaterEqualX.next = currNode;
                //System.out.println("Greater Node Data" + greaterEqualX.data);
                prev.next = currNode.next;
                currNode.next = null;
                greaterEqualX = greaterEqualX.next;
            }else{
                prev = currNode;
            }
            currNode = prev.next;
        }
        if(attachedNode.next != null){
            prev.next = attachedNode.next;
        }
        return inputNode;
    }
}
