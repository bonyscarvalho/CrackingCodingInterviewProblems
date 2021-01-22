package ChapterLinkedList;

public class KthToLast {
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
        //inputNode = getKthToLastNodeApproach1(inputNode, 3);

        inputNode = getKthToLastNodeApproach2(inputNode, 3);

        System.out.println("Kth to the Last");
        display(inputNode);
    }

    //In this approach we have 2 pointers 1st Pointer goes till k and then we move both pointer till 1st pointer ends which will be left with only last k
    private static Node getKthToLastNodeApproach2(Node inputNode, int k) {
        if(inputNode == null) return null;

        Node p1 = inputNode, p2 = inputNode;

        for(int i = 0; i < k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //find the Len and then iterate throguh Len - k and return the next node
    private static Node getKthToLastNodeApproach1(Node inputNode, int k) {
        if(inputNode == null) return inputNode;

        Node currNode = inputNode;
        int len = 0;
        while(currNode != null){
            currNode = currNode.next;
            len++;
        }
        System.out.println("Length of LinkedList: "+len);
        if(len <= k) return null;

        currNode = inputNode;
        for(int i = 0; i < len - k; i++){
            currNode = currNode.next;
        }

        return currNode;
    }
}
