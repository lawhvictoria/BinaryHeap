/*
Victoria Law
vhlaw@calpoly.edu
2/5/16
Project 2
*/

import java.util.Arrays;

public class BinHeap <T extends Comparable<? super T>>{
	
	private T[] array; 
	private int sizeHeap; //this keeps track of the number of elements in the heap
	
	public static class MyException extends RuntimeException //this is to prevent deleteMin from crashing. 
	{
		public MyException()
		{
			super();
		}
		public MyException(String s)
		{
			super(s);
		}
	}
	
	public BinHeap() //constructor without paramenters and allocates 100 spaces.
	{
		array = (T[]) new Comparable[100];
		sizeHeap = 0;
	}
	
	public BinHeap(int sizeArray) //constructor that takes an int as a parameter and allocates the amount of space requested.
	{
		array = (T[]) new Comparable[sizeArray];
		sizeHeap = 0;
	}
	
	public void insert(T elem) //inserting element into the heap.
	{
		if(sizeHeap == array.length - 1) //if the array is full, this doubles the size of the array.
		{
			T[] newArr = (T[])(new Comparable[array.length*2]);
			for(int i = 0; i < array.length; i++)
			{
				newArr[i] = array[i];
			}
			array = newArr;
		}
		sizeHeap++;
		array[sizeHeap] = elem; //inserts the element into the end of the array.

		for(int i = sizeHeap; i > 1; i--) // percolates up and rearrange elements to keep order and structure property. 
		{
			if(array[i].compareTo(array[i / 2]) < 0)
			{
				T temp = array[i];
				array[i] = array[i / 2];
				array[i / 2] = temp;
			}
		}
	}
	
	public T deleteMin() //deletes the minimum element in the heap.
	{
		if(isEmpty()) //if the heap is empty, throw exception.
		{
			throw new MyException();
		}
		else
		{
			T min = array[1]; //stores deleted element for returning later.
			array[1] = array[sizeHeap]; //puts the last element of the array and fills the empty hole. 
			sizeHeap--; //deccreases the size of the heap.

			for(int i = sizeHeap; i > 1; i--) //percolate up to rearrange elements to keep order and structure property.
			{
				if(array[i].compareTo(array[i / 2]) < 0)
				{
					T temp = array[i];
					array[i] = array[i / 2];
					array[i / 2] = temp;
				}
			}
			return min;
		}
	}
	
	public boolean isEmpty() //checks if the heap is empty. 
	{
		return sizeHeap == 0;
	}
	
	public int size() //returns the size of the array
	{
		return sizeHeap;
	}
	
	public String toString() //prints the elements inside the heap/array. 
	{
		String print = "";
		for(int i = 1; i < sizeHeap + 1; i++)
		{
			print += " " + array[i];
		}
		return print;
	}
	
}
