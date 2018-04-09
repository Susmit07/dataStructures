package com.ds.stack;

import java.util.EmptyStackException;

public class StackLinkedListImplementation {

	private Node top;

	public StackLinkedListImplementation(){
		top = null;
	}

	public int size(){

		int size = 0;
		Node pointer = top;
		while(pointer != null){
			pointer = pointer.next;
			size++;
		}
		return size;
	}


	public void push(int x){

		Node temp = new Node(x);
		temp.next = top;
		top = temp;
	}

	public int pop(){
		int x;

		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		x = top.data;
		top = top.next;
		return x;
	}

	private boolean isEmpty() {
		return (top == null);
	}

}

