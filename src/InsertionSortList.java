// Java program to sort link list
// using insertion sort

public class InsertionSortList
{
	node head;
	node sorted;

	class node
	{
		int val;
		node next;

		public node(int val)
		{
			this.val = val;
		}
	}

	void push(int val)
	{
		node newnode = new node(val);
		newnode.next = head;
		head = newnode;
	}

	void insertionSort(node headref)
	{
		sorted = null;
		node current = headref;
		while(current != null){
            node nextNode = current.next;
            if(sorted == null || current.val <= sorted.val){
                current.next = sorted;
                sorted = current;
            }
            else{
                node tempCurrent = sorted;
                while(tempCurrent.next != null && current.val > tempCurrent.next.val){
                    tempCurrent = tempCurrent.next;
                }
                current.next = tempCurrent.next;
                tempCurrent.next = current;
            }
            current = nextNode;
        }
		head = sorted;
	}

	void printlist(node head)
	{
		while (head != null)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args)
	{
		InsertionSortList list = new InsertionSortList();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		System.out.println("Linked List before Sorting..");
		list.printlist(list.head);
		list.insertionSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(list.head);
	}
}
