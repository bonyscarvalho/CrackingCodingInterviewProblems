package ChapterLinkedList;

public class ReverseAndPalindromeCheck {
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
        //removeDupsApproach1(inputNode);       //Extra Space

        Node result = reverseNode(inputNode);         //No Space
        System.out.println("Revered Node");
        display(result);
        Boolean isPalindrome = isPalindromeNode(inputNode, result);
        System.out.println("\n" +
                " Palindrome Check " +isPalindrome);
    }

    private static Boolean isPalindromeNode(Node inputNode, Node reversedNode) {
        while(inputNode != null && reversedNode != null){
            if(inputNode.data != reversedNode.data){
                return false;
            }
            inputNode =inputNode.next;
            reversedNode = reversedNode.next;
        }
        return true;
    }

    private static Node reverseNode(Node inputNode) {
        Node head = null;

        while(inputNode != null){
            Node temp = new Node(inputNode.data);
            temp.next = head;
            head = temp;
            inputNode = inputNode.next;
        }

        return head;
    }
}
