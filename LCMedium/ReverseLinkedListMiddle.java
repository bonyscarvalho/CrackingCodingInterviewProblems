package LeetCodeMedium;

public class ReverseLinkedListMiddle {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        //System.out.println(head);

        reverseBetween(head, 2, 4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int start, int end) {
        if(head == null) return head;

        ListNode currNode = head;
        ListNode prevNode = null;

        int idx = 1;

        //Getting previous
        while(idx != start){
            prevNode = currNode;    //Node - 1
            currNode = currNode.next;
            idx++;
        }

        ListNode startingNode = currNode;   //Node --2
        ListNode afterNode = currNode;  //next Node in Reversing the list   //Like to point to the next Node
        ListNode prev = null;
        int steps = end - start;

        while(steps >= 0){
            afterNode = afterNode.next; //moving to next node
            currNode.next = prev;   //curr node pointing to prev
            prev = currNode;    //prev node pointing to curr
            currNode = afterNode;   // curr node pointing to afterNode for next node
            steps--;
        }

        startingNode.next = currNode;   //Node 2 point to node 5
        if(prevNode == null){
            head = prev;        //Start was 1 so head will be new prev node
        }else{
            prevNode.next = prev;           //Node 1 pointing to node 4
        }


        return head;
    }
}
