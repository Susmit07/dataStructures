package com.ds.queue;

import java.util.NoSuchElementException;

public class QueueLinkedList {

	private Node front;
	private Node rear;

	public QueueLinkedList(){
		front = null;
		rear = null;
	}

	public int size(){

		int size =0;
		Node pointer = front;
		while(pointer != null){
			size++;
			pointer = pointer.next;
		}
		return size;
	}

	public void insert(int x){

		Node temp = null;
		if(front == null){
			temp = new Node(x);
			front = temp;
		}else{
			temp = new Node(x);
			rear.next = temp;
		}
		rear = temp; // to avoid the traversal to the end of list maintain a rear node which will point end
	}

	public boolean isEmpty(){
		return (front == null);
	}

	public int peek(){

		if(isEmpty()){
			System.out.println("Queue Underflow!! ");
			throw new NoSuchElementException();
		}
		return front.data;
	}

	public int delete(){

		int x;
		if(isEmpty()){
			System.out.println("Queue Underflow!! ");
			throw new NoSuchElementException();
		}
		x = front.data;
		front = front.next;
		return x;
	}
	
	public void display(){
		
		Node pointer = front;
		if(isEmpty()){
			System.out.println("Queue is empty !!");
			return;
		}
		System.out.print("The queue is: \n");
		while(pointer != null){
			System.out.print(pointer.data+ " ");
			pointer = pointer.next;
		}
	}
	
	public static void main(String[]args){

		QueueLinkedList queue = new QueueLinkedList();
		for (int i =1 ; i<=7; i++){
			queue.insert(i);
		}
		queue.display();
		queue.delete();
		System.out.println();
		System.out.println("After Deletion!!");
		queue.display();
		queue.insert(8);
		System.out.println();
		System.out.println("After Insertion!!");
		queue.display();
	}
}
