public class DeleteDuplicatesList {
    /**Given the head of a sorted linked list, 
     * delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well. */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode t = temp,s=temp;
        while(t.next != null){
            if(s.val == t.next.val)
                t.next = t.next.next;
            else{
                t=t.next;
                s=t;
            }
            
        }
        return temp;
        
    }
}
