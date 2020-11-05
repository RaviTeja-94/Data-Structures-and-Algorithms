
public class LinkedListExcersise {

	private Node first;
	private Node last;
	private int size;
	private class Node {
		private int val;
		private Node next;
		public Node(int val) {
			this.val=val;
		}
	}
	
	public void addLast(int value) {
		Node node =  new Node(value);
		if(first==null) {
			first=node;
			last=node;
		} else {
//			Node temp=first;
//			while(temp.next!=null) {
//				temp=temp.next;
//			}
//			temp.next=node;
//			last=node;
			
			last.next=node;
			last=node;
		}
		size++;
		
	}
	
	public void traverse() {
		Node temp=first;
		while(temp!=null) {
			System.out.println(temp.val+" ");
			temp=temp.next;
		}
	}
	
	public static void traverse(Node temp) {
		while(temp!=null) {
			System.out.println(temp.val+" ");
			temp=temp.next;
		}
	}
	
	public void reverseList() {
		//maintain prev, curr and next
		if(first==null) {
			return;
		}
		Node prev = first;
		Node curr=prev.next;
		
		while(curr!=null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		last = first;
		last.next=null;
		first = prev;
	}
	
	public void reverseListUsingRecursion(Node curr) {
		if(curr==null || curr.next==null) {
			first=curr;
			return;
			//return curr;
		}
		
		reverseListUsingRecursion(curr.next);
		
		curr.next.next = curr;
		curr.next=null;
		last=curr;
		//return rest;
		
	}
	
	public int getKthNodeFromTheList(int k) {
		//idea is to have two pointers with k-1 distance apart and move both pointers until second pointer reaches the end
		//then we have first one at the correct node, we can return first pointer node value
		if(first==null) throw new IllegalStateException();
		Node f=first;
		Node s=first;
		for(int i=0;i<k-1;i++) {
			s=s.next;
			if(s==null) {
				throw new IllegalArgumentException();
			}
		}
		
		while(s.next!=null) {
			f=f.next;
			s=s.next;
		}
		
		
		return f.val;
	}
	
	public int findMidOfLinkedList() {
		//use slow and fast pointer technique to find mid, if first ptr reaches end, slow pointer points to mid value
		if(first==null) return -1;
		Node slow=first;
		Node fast=first;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
			if(fast!=null) {
				fast=fast.next;
			}
		}
		return slow.val;
	}
	
	
	public void findJnPointAndPrintCycleNodes() {
		//find cycle(use slow,f ast pointers, if they meet->cycle)
		//find junction(once met put back slow ptr to first node and move one step for both ptrs, where they meet is the junction)
		//print nodes of junction
		if(first==null)  {
			System.out.println("empty list");
			return;
		}
		Node slow=first;
		Node fast=first;
		Node junNode=null;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
			if(fast!=null) {
				fast=fast.next;
			}
			
			if(slow==fast) {//cycle exists
				//find the jucntion node
				System.out.println("Cycle exists...");
				slow=first;
				while(slow!=fast) {
					slow=slow.next;
					fast=fast.next;
				}
				
				junNode=slow;
				break;
			}
		}
		if(junNode!=null) {
			System.out.println("junction node is "+junNode.val);
			System.out.println("cycle nodes are...");
			Node tempjn=junNode;
			while(junNode!=null) {
				
				System.out.println(junNode.val+" ");
				junNode=junNode.next;
				if(tempjn==junNode) {
					break;
				}
			}
		} else {
			System.out.println("No cycle exists...");
		}
		
	}
	
	public void makeOddEvenList() {
		if(first==null || first.next==null || first.next.next==null) {
			return;
		}
		
		//go till the end and modify pointers
		Node end=last;
		Node temp=first;
		int times=(size%2)==0?size/2:(size/2)+1;
		
		while(times>0) {
			end.next=temp.next;
			temp.next=temp.next.next;
			end.next.next=null;
			end=end.next;
			temp=temp.next;
			last=end;
			times--;
		}
		
	}
	
	public static Node MergeTwoSortedLists(Node head1, Node head2 ) {
		if(head1==null) return head2;
		if(head2==null) return head1;
		
		Node result_head=null;
		
		if(head1.val<head2.val) {
			result_head = head1;
			head1=head1.next;
		}
		else {
			result_head = head2;
			head2=head2.next;
		}
		
		Node tempres = result_head;
		
		while(head1!=null && head2!=null) {
			if(head1.val<head2.val) {
				tempres.next=head1;
				head1=head1.next;
			}
			else {
				tempres.next=head2;
				head2=head2.next;
			}
			tempres=tempres.next;
		}
		
		if(head1==null) {
			tempres.next=head2;
		}
		else {
			tempres.next=head1;
		}
		
		return result_head;
	}
	public static void main(String[] args) {
		LinkedListExcersise t = new LinkedListExcersise();
		t.addLast(10);
		t.addLast(20);
		t.addLast(30);
		t.addLast(40);
		t.addLast(50);
		LinkedListExcersise t1= new LinkedListExcersise();
		t1.addLast(1);
		t1.addLast(11);
		t1.addLast(16);
		t1.addLast(121);
		Node res= MergeTwoSortedLists(t.first, t1.first);
		traverse(res);
		
	}
} 