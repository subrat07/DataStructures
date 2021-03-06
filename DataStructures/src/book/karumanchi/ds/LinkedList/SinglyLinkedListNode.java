/**
 * 
 */
package book.karumanchi.ds.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author subratt
 *
 */
public class SinglyLinkedListNode {
	
	int data;
	SinglyLinkedListNode next;

	/**
	 * 
	 */
	public SinglyLinkedListNode(int data) {
		this.data=data;
		this.next=null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SinglyLinkedListNode getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode next) {
		this.next = next;
	}
	
	public static int length(SinglyLinkedListNode head) {
		int length=0;
		if(head==null){
		return length;	
		}
		while(head.getNext() != null){
			head=head.getNext();
			length++;
		}
		return length;
	}
	

	public static void addNodeAtLast(SinglyLinkedListNode head , int data){
		if(head==null){
			head=	new SinglyLinkedListNode(data);
		}
		else{
			while(head.getNext() != null){
				head=head.getNext();
			}	
			SinglyLinkedListNode node=new SinglyLinkedListNode(data);
			head.setNext(node);
		}
	}
	

	public static void deleteLastNode(SinglyLinkedListNode head) throws RuntimeException {
		if(head==null){
			throw new RuntimeException("LinkedList is empty"); 
			
		}
		while(head.getNext() !=null && head.getNext().getNext() !=null){
			head=head.getNext();
		}
		head.setNext(null);
		
	}
	
	public static void deleteNode(SinglyLinkedListNode head, int data) throws RuntimeException {
		int position=0;
		if(head==null){
			throw new RuntimeException("LinkedList is empty"); 
			
		}
		while(head !=null){
			position++;
			if(head.getData() == data || (head.getNext() !=null && head.getNext().getData() == data)){
				head.setNext(head.getNext() !=null?head.getNext().getNext():null);
				System.out.println("Deleted data "+data+ " at poition "+position);
			}
			else{
			head=head.getNext();
			}
		}
		
	}
	
	public static String printLinkedList (SinglyLinkedListNode head) {
		List<Integer> linkedList= new ArrayList<Integer>();
		while(head !=null){
			linkedList.add(head.getData());
			head=head.getNext();
		}
		System.out.println(linkedList.toString());
		return linkedList.toString();
		
	}
	
	public static void addNodeInStarting (SinglyLinkedListNode head, int data) {
		if(head==null){
			head=	new SinglyLinkedListNode(data);
		}
		else{
			SinglyLinkedListNode newHead=new SinglyLinkedListNode(data);
			newHead.setNext(head);
			head=newHead;
		}

		printLinkedList(head);
	}
	
	public static void reverseLinkedList(SinglyLinkedListNode head) throws RuntimeException {
		if(head==null){
			throw new RuntimeException("LinkedList is empty");
		}
		
		if(head.getNext() ==null){
			System.out.print(head.getData());
			return;
		}
		reverseLinkedList(head.getNext());
		head.getNext().setNext(head);
		System.out.print("->"+head.getData());
	}
	
	public static void insertNodeAtKthPosition(SinglyLinkedListNode head , int position, int data)throws RuntimeException {
		if(head ==null){
			if(position==1){
				head= new SinglyLinkedListNode(data);
				return;
			}
			throw new RuntimeException("LinkedList is empty");
		}
		SinglyLinkedListNode initHead=head;
		while (position >2){
			if(head.getNext() ==null){
				throw new RuntimeException("Not enough element in linkedList");
			}
			head=head.getNext();
			position -=1;
		}
		SinglyLinkedListNode nodeAtK= new SinglyLinkedListNode(data);
		nodeAtK.setNext(head.getNext());
		head.setNext(nodeAtK);

		printLinkedList(initHead);
	}
	
	
	 public static SinglyLinkedListNode getLastNode (SinglyLinkedListNode head) {
		 if(head !=null){
			 while(head.getNext() !=null){
				 head=head.getNext();
			 }
		 }
		 return head;
		 
	 }
	
	public static int getMiddleElement(SinglyLinkedListNode head){
		SinglyLinkedListNode slow=head;
		SinglyLinkedListNode fast=head;
		while(fast !=null && fast.getNext() !=null){
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		System.out.println(slow.getData());
		return slow.getData();
	}
	
	public static int findNthNodeFromLast(SinglyLinkedListNode head, int n){
		SinglyLinkedListNode backHead=head;
		while (n>0){
			head=head.getNext();
			n--;
		}
		while(head !=null){
			head=head.getNext();
			backHead=backHead.getNext();
		}
		System.out.println(backHead.getData());
		return backHead.getData();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1 ->5-> 7-> 9-> 3-> 18->13 ->13
		SinglyLinkedListNode head=new SinglyLinkedListNode(1);
		addNodeAtLast(head, 5);
		addNodeAtLast(head, 7);
		addNodeAtLast(head, 9);
		addNodeAtLast(head, 3);
		addNodeAtLast(head, 18);
		addNodeAtLast(head, 13);
		addNodeAtLast(head, 13);
		//printLinkedList(head);
		//deleteLastNode(head);
		//printLinkedList(head);
		//head.addNodeAtLast(head, 13);
		//deleteNode(head, 13);
		//printLinkedList(head);
		//addNodeInStarting(head, 25);
		//reverseLinkedList(head);
		//getMiddleElement(head);
		//1 ->5-> 17 ->7-> 9-> 3-> 18->13 ->13
		//insertNodeAtKthPosition(head, 3, 17);
		//getMiddleElement(head);
		//findNthNodeFromLast(head, 3);
	}

}
