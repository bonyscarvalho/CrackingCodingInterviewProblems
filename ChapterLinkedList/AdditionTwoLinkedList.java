package ChapterLinkedList;

public class SumListNode {
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
        //Node resultNode = addTwoLinkedListNodeIterativeApproach(inputNode1, inputNode2);

        Node resultNode = addTwoLinkedListNodeRecursiveApproach(inputNode1, inputNode2, 0);

        System.out.println("Addition of 2 Nodes");
        display(resultNode);
    }

    private static Node addTwoLinkedListNodeRecursiveApproach(Node inputNode1, Node inputNode2, int carry) {
        if(inputNode1 == null && inputNode2 == null && carry == 0) return null; // Base Case

        int value = carry;

        if(inputNode1 != null){
            value += inputNode1.data;
        }
        if(inputNode2 != null){
            value += inputNode2.data;
        }

        Node result = new Node(value % 10);

        if(inputNode1 != null || inputNode2 != null){
            Node moreAddition = addTwoLinkedListNodeRecursiveApproach(
                    inputNode1 == null ? null : inputNode1.next,
                    inputNode2 == null ? null : inputNode2.next,
                    value >= 10 ? 1 : 0
            );
            result.next = moreAddition;
        }

        return result;
    }

    private static Node addTwoLinkedListNodeIterativeApproach(Node inputNode1, Node inputNode2) {
        if(inputNode1 == null) return inputNode2;
        if(inputNode2 == null) return inputNode1;

        Node result = new Node(0);
        Node headResult = result;

        int carry = 0;
        Node currNode1 = inputNode1;
        Node currNode2 = inputNode2;
        int len1 = lenOfNode(currNode1);
        int len2 = lenOfNode(currNode2);


        int minLen = Math.min(len1, len2);
        int i = 0;

        while(i < minLen){
            int currNode1Value = currNode1.data;
            int currNode2Value = currNode2.data;
            int sum = currNode1Value + currNode2Value + carry;
            System.out.println("Sum of each Node " + sum);

            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            Node sumNode = new Node(sum);
            result.next = sumNode;

            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
            result = result.next;
            i++;
        }

        if(len1 > len2){

            int sum = carry + currNode1.data;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            result.next = new Node(sum);

        }else if(len2 > len1){

            int sum = carry + currNode1.data;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            result.next = new Node(sum);

        }
        if(carry == 1){
            result.next = new Node(carry);
        }

        return headResult.next;
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

