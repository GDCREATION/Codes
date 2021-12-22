public class ReorderListNotSorted {

    /**You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed. */

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        int len=0;
        while(curr != null){
            ListNode current = new ListNode(curr.val);
            current.next = prev;
            prev = current;
            curr = curr.next;
            len++;
        }
        if(len>1){
            int k=(len+1)/2;
            curr = head;
            for(int i=0;i<k;i++){
                ListNode current = curr.next;
                ListNode backCurrent= prev.next;
                prev.next = current;
                curr.next = prev;
                if(i != k-1)
                    curr = current;
                prev = backCurrent;
            }
            if(len%2 == 0)
                curr.next.next = null;
            else
                curr.next = null;
        }
    }
}
