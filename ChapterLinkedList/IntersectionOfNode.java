package ChapterLinkedList;

public class IntersectionNode {
    static class SizeAndTailNode{
        Node tail;
        int size;

        public SizeAndTailNode(Node t, int s) {
            tail = t;
            size = s;
        }
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
        inputNode1.appendToTail(0);
        inputNode1.appendToTail(2);
        inputNode1.appendToTail(3);
        inputNode1.appendToTail(4);
        inputNode1.appendToTail(5);
        inputNode1.appendToTail(6);
        inputNode1.appendToTail(7);

        Node inputNode2 = new Node(8);
        inputNode2.appendToTail(9);
        inputNode2.appendToTail(4);
        inputNode2.appendToTail(5);
        inputNode2.appendToTail(6);
        inputNode2.appendToTail(7);

        System.out.println("Orginal Linked List Node 1");
        display(inputNode1);
        System.out.println("Orginal Linked List Node 2");
        display(inputNode2);

        Node intersectionNode = isIntersectionNode(inputNode1, inputNode2);

        System.out.println("Intersection of 2 Nodes");
        display(intersectionNode);
    }

    private static Node isIntersectionNode(Node inputNode1, Node inputNode2) {
        if(inputNode1 == null || inputNode2 == null) return null;

        Node inersectionNode = null;
        SizeAndTailNode tailNode1 = getTailNode(inputNode1);
        SizeAndTailNode tailNode2 = getTailNode(inputNode2);
        int lenNode1 = tailNode1.size;
        int lenNode2 = tailNode2.size;

        
        System.out.println("Tail Node 1: " + tailNode1.tail.data + "Tail Node 2: " + tailNode2.tail.data);
        System.out.println("Size Node 1: " + lenNode1 + "Tail Node 2: " + lenNode2);
        
        //both tails should be pointing to same reference
        if(tailNode1.tail == tailNode2.tail){       //we are comparing the reference and not the values.
            return null;
        }


        if(lenNode1 > lenNode2){
            inputNode1 = moveNodeForward(inputNode1, lenNode1 - lenNode2);
        }else if(lenNode2 > lenNode1){
            inputNode2 = moveNodeForward(inputNode2, lenNode2 - lenNode1);
        }

        while(inputNode1 != null && inputNode2 != null){
            System.out.println("Node 1: " + inputNode1.data + " Node 2: " + inputNode2.data);
            if(inputNode1 == inputNode2){
                inputNode1.next = inersectionNode;
                inersectionNode = inputNode1;
                return inersectionNode;
            }
            inputNode1 = inputNode1.next;
            inputNode2 = inputNode2.next;
        }

        return inersectionNode;
    }

    private static SizeAndTailNode getTailNode(Node currNode) {
        if(currNode == null)return null;
        int size = 1;
        Node tail = currNode;

        while(tail.next != null){
            tail = tail.next;
            size++;
        }
        return new SizeAndTailNode(tail,size);
    }

    private static Node moveNodeForward(Node currNode, int forwardBy) {
        int i = 0;
        while (i < forwardBy){
            currNode = currNode.next;
            i++;
        }
        return currNode;
    }

    private static int lenOfNode(Node currNode) {
        int len = 0;

        while(currNode != null){
            currNode = currNode.next;
            len++;
        }
        return len;
    }
}
