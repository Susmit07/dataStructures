package com.ds.stack;

import java.util.EmptyStackException;

public class StackArray {

	public int [] stackArray;
	private int top;

	public StackArray(){
		stackArray = new int[10];
		top = -1;
	}

	public StackArray(int maxSize){
		stackArray = new int[maxSize];
		top = -1;
	}

	public int size(){
		return top+1;
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public boolean isFull(){
		return (top == stackArray.length-1);
	}

	public void push(int x){

		if(isFull()){
			System.out.println("Stack Overflow!!");
			return;
		}

		top = top+1;
		stackArray[top] = x;
	}

	public int pop(){

		int x ;
		if(isEmpty()){
			System.out.println("Stack Underflow!!");
			throw new EmptyStackException();
		}
		x = stackArray[top];
		top = top-1;
		return x;
	}

	public int peek(){

		if(isEmpty()){
			System.out.println("Stack Underflow!!");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}

	public void display(){

		if(isEmpty()){
			System.out.println("Stack Underflow!!");
			throw new EmptyStackException();
		}

		System.out.println("The Stack is: ");
		for(int i = top; i<=0; i--){
			System.out.println(stackArray[i]);
		}
	}

}



