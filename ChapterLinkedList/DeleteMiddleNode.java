package ChapterLinkedList;

public class DeleteMiddleNode {
    public static void display(Node n){
        while (n != null){
            System.out.print("Node Data: " + n.data +" ");
            n= n.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        Node inputNode = new Node(1);
        inputNode.appendToTail(2);
        inputNode.appendToTail(3);
        inputNode.appendToTail(4);
        inputNode.appendToTail(5);
        inputNode.appendToTail(6);
        inputNode.appendToTail(7);
        inputNode.appendToTail(8);
        inputNode.appendToTail(9);
        inputNode.appendToTail(10);
        System.out.println("Orginal Linked List");
        display(inputNode);
        inputNode = deleteMiddleNode(inputNode, 6);

        System.out.println("After Deleting the middle Node");
        display(inputNode);
    }
    
//    If only given access to the Deleting node.
//    private static boolean deleteMiddleNode(Node inputNode) {
//        if(inputNode == null || inputNode.next == null) return false;
// 
//        Node nextNode = inputNode.next;
//        inputNode.data = nextNode.data;
//        inputNode.next = nextNode.next;    
//        return true;
//    
//    }

    private static Node deleteMiddleNode(Node inputNode, int middleNode) {
        if(inputNode == null) return inputNode;
        Node currNode = inputNode;
        Node prevNode = null;

        if(currNode.data == middleNode) currNode = currNode.next;

        while (currNode != null){
            if((currNode.data == middleNode) && (currNode.next == null)){
                return inputNode;
            }
            if(currNode.data == middleNode){
                prevNode.next = currNode.next;
            }else {
                prevNode = currNode;
            }
            currNode = currNode.next;
        }

        return inputNode;
    }
}
