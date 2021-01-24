package ChapterLinkedList;

public class PalindromeCheckRecursive {
    public static class ResultWrapper {
        Node node;
        Boolean isPalindrome;

        public ResultWrapper(Node head, boolean b) {
            node = head;
            isPalindrome = b;
        }
    }

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
        inputNode.appendToTail(4);
        inputNode.appendToTail(3);
        inputNode.appendToTail(2);
        inputNode.appendToTail(1);
        //inputNode.appendToTail(7);
        System.out.println("Given Node");
        display(inputNode);

        int lenNode = lenOfNode(inputNode);
        ResultWrapper result = isPalindromeLinkedList(inputNode, lenNode);
        System.out.println("Result of Being Palindrome is " + result.isPalindrome);
    }

    private static ResultWrapper isPalindromeLinkedList(Node head, int lenNode) {
        if(head == null || lenNode == 0) {          // if len is EVEN
            return new ResultWrapper(head, true);
        }else if(lenNode == 1){     // if len is ODD
            return new ResultWrapper(head.next, true);
        }

        ResultWrapper p = isPalindromeLinkedList(head.next, lenNode - 2);

        //check is previous value was false, if yes then return false to ALL the next call.
        if(!p.isPalindrome || p.node == null){
            return p ;
        }

        //Assigning the values to the next Node in the recursive stack
        p.isPalindrome = (head.data == p.node.data);
        p.node = p.node.next;

        return p;
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
