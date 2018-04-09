package com.ds.linkedlist;

import java.util.Scanner;

public class SingleLinkedList {

	// First node of the List
	public Node start;

	public SingleLinkedList(){
		start = null;
	}

	public void DisplayList(){

		Node pointer;
		if(start == null){
			System.out.println("List is Empty");
			return;
		}

		System.out.println("List is: ");
		pointer = start;

		while (pointer != null){

			System.out.print(pointer.data+" -> ");
			pointer = pointer.next;
		}
	}

	public void countNodes(){

		Node pointer;
		if(start == null){
			System.out.println("List is Empty");
			return;
		}

		pointer = start;
		int counter = 0;
		while (pointer != null){
			counter++;
			pointer = pointer.next;
		}
		System.out.println("Total No of Nodes: "+counter);
	}

	public void InsertioninBeginning(int data){

		Node temp = new Node(data);
		temp.next = start;
		start = temp;
	}

	public void InsertioninEnd(int data){

		Node pointer;
		Node temp = new Node(data);

		//If start is null, assign the data to start
		if(start == null){
			start = temp;
			return;
		}
		pointer = start;
		while(pointer.next != null){
			pointer = pointer.next;
		}
		pointer.next = temp;
	}

	public void insertAfter(int data, int x){

		Node pointer = start;
		while(pointer != null){
			if(pointer.data == x){
				break;
			}
			pointer = pointer.next;
		}
		if(pointer == null){
			System.out.println(x+ " is not present in the list!!");
		}else{
			Node temp = new Node(data);
			temp.next = pointer.next;
			pointer.next = temp;
		}
	}

	public void insertBefore(int data, int x){

		Node pointer = start;
		Node temp;

		if(start == null){
			System.out.println("List is Empty!!");
			return;
		}
		if(x == start.data){
			temp = new Node(data);
			temp.next = start;
			start = temp;
			return;
		}
		while(pointer != null){
			if(pointer.next.data == x){
				break;
			}
			pointer = pointer.next;
		}
		if(pointer == null){
			System.out.println(x+ " is not present in the list!!");
		}else{
			temp = new Node(data);
			temp.next = pointer.next;
			pointer.next = temp;
		}
	}


	public void insertAtPosition(int data, int k){

		Node temp;
		int i;
		if(k==1){
			temp = new Node(data);
			temp.next = start;
			start = temp;
			return;
		}

		Node pointer = start;
		for(i=1; i<k-1 && pointer != null; i++){
			pointer = pointer.next;
		}
		if(pointer == null){
			System.out.println("Insert only upto "+i+" th position.");
		}else{
			temp = new Node(data);
			temp.next = pointer.next;
			pointer.next = temp;

		}
	}

	public void deleteFirstNode(){

		if(start == null){
			return;
		}
		start =start.next;
	}

	public void deleteLastNode(){

		if(start == null){
			return;
		}

		if(start.next == null){
			start = null;
			return;
		}

		Node pointer = start;
		// refer to the second last node of the list.
		while(pointer.next.next != null){
			pointer = pointer.next;
		}

		pointer.next = null;
	}	

	public void deleteNode(int x){

		if(start == null){
			System.out.println("List is empty!!");
			return;
		}

		// first Node
		if(start.data == x){
			start = start.next;
		}
		Node pointer = start;
		while(pointer.next !=null){
			if(pointer.next.data == x){
				break;
			}
			pointer = pointer.next;
		}
		if(pointer.next == null){
			System.out.println("Element "+x+" not in list!!");
		}else{
			pointer.next = pointer.next.next;
		}
	}

	public void createList(){
		int i, n , data;

		@SuppressWarnings("resource")
		Scanner  scanner =  new Scanner(System.in);
		System.out.println("Enter the number of Nodes : ");
		n = scanner.nextInt();

		if(n==0){
			return;
		}
		for(i = 1; i<=n; i++){
			System.out.print("Enter element to be inserted: ");
			data = scanner.nextInt();
			InsertioninEnd(data);
		}
	}

	public boolean searchElement(int x){

		Node pointer;
		int position = 1;

		pointer = start;

		while(pointer.next != null){
			if(pointer.data == x){
				break;
			}
			position ++;
			pointer = pointer.next;
		}
		if(pointer == null){
			System.out.println(x+ " is not found in list");
			return false;
		}else{
			System.out.println(x+ " is found at position: "+ position);
			return true;
		}
	}

	public static void main (String[]args){
		SingleLinkedList singleLinkedList =  new SingleLinkedList();
		singleLinkedList.createList();
		singleLinkedList.DisplayList();
		System.out.println(" ");
		/*singleLinkedList.countNodes();
		singleLinkedList.searchElement(11);
		singleLinkedList.insertAfter(20, 12);
		singleLinkedList.insertBefore(90, 12);
		singleLinkedList.DisplayList();*/
		singleLinkedList.deleteFirstNode();
		singleLinkedList.DisplayList();
	}
}
