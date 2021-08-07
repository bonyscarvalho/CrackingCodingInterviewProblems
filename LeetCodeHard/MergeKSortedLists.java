package LeetCodeHard;
//23. Merge k Sorted Lists
public class MergeKSortedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        //lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next = new ListNode(4);

        ListNode third = new ListNode(1);
        third.next = new ListNode(3);
        ListNode[] listNodes = {first, second, third};
        ListNode sorted = mergeKLists(listNodes);
        System.out.print("Sorted Single List: ");
        while (sorted != null){
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];

        int mid = start + (end - start)/2;
        ListNode leftSide = mergeKLists(lists, start, mid);
        ListNode rightSide = mergeKLists(lists, mid + 1, end);

        return mergeListNodes(leftSide, rightSide);
    }

    private static ListNode mergeListNodes(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2;
                l2 = l2.next;
            }else if(l2 == null){
                curr.next = l1;
                l1 = l1.next;
            }else {
                if(l1.val < l2.val){
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            curr= curr.next;
        }

        return result.next;
    }
}
