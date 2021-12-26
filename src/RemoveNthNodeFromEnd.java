
 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode countNode = head;
        int len = 0;
        while(countNode != null){
            countNode = countNode.next;
            len++;
        }
        countNode = head;
        len = len -n -1;
        int i =0;
        while(i<len){
            countNode = countNode.next;
            i++;
        }
        if(len == -1)
            head=head.next;
        else if(countNode.next != null)
            countNode.next = countNode.next.next;
        
        return head;
        
    }
}

