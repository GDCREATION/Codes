public class RemoveLinkListElement {
    /**Given the head of a linked list and an integer val,
     * remove all the nodes of the linked list that has Node.val == val, and return the new head. */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        temp.next = head;
        while(temp.next != null){
            if(temp.next.val == val)
                temp.next =  temp.next.next;
            else
                temp = temp.next;
        }
        return res.next;
    }
}
