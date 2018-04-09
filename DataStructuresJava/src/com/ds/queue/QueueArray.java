package com.ds.queue;

import java.util.NoSuchElementException;

public class QueueArray {

	public int [] queueArray;
	public int front;
	public int rear;

	public QueueArray(){
		queueArray = new int[10];
		front = -1;
		rear = -1;
	}

	public QueueArray(int maxSize){
		queueArray = new int[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty(){
		if(front == -1 || rear == front+1){
			return true;
		}else{
			return false;
		}
	}

	public boolean isFull(){
		return (rear == queueArray.length-1);
	}

	public void insert(int x){

		if(isFull()){
			System.out.println("Queue Overflow!! ");
			return;
		}
		if(front == -1){
			front = 0;
		}
		rear = rear +1;
		queueArray[rear] = x;
	}

	public int delete(){

		int x;
		if(isEmpty()){
			System.out.println("Queue Underflow!! ");
			throw new NoSuchElementException();
		}
		x = queueArray[front];
		front = front +1;
		return x;
	}

	public int peek(){

		if(isEmpty()){
			System.out.println("Queue Underflow!! ");
			throw new NoSuchElementException();
		}
		return queueArray[front];
	}

	public void display(){

		if(isEmpty()){
			System.out.println("Queue is empty !!");
			return;
		}
		System.out.print("The queue is: \n");

		for(int i = front; i<=rear; i++){
			System.out.print(queueArray[i]+" ");
		}
	}


	public static void main(String[]args){

		QueueArray queue = new QueueArray();
		for (int i =1 ; i<=7; i++){
			queue.insert(i);
		}
		queue.display();
		queue.delete();
		System.out.println();
		System.out.println("After Deletion!!");
		queue.display();
	}
}
