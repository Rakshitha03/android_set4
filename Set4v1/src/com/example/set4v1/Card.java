package com.example.set4v1;

import android.util.Log;

public class Card
{
    List l1,l2,l3,l4;
    int n;
	public Card()
    {
		 l1 = new List();
	     l2 = new List();
	     l3 = new List();
	     l4 = new List();
	     n = 16;
	     number = new int[n];
		 result = new int[n];
		 i = 0; 
    }

	int[] number;
	int[] result;
    int i;
	
    DNode temp=null;
   
	void generate_random()
	{	   
	    n = 16;
	 	for(int a=0; a<n; a++)
	 	{
	 		number[a]=a+1;
	 	}
	 	
		for(int b=0; b<16; b++)
		{		
			System.out.println("N" +n);
			System.out.println(b+"Enterd second time");
			int r=(int)(Math.random() * n);
			result[b] = (number[r] % 4) + 1;
			number[r] = number[n-1];
			n--;
		}
	}
	   
	void create_Lists(List l)
	{
		Log.d("Test", "Entered list");
		for(int j=0; j<4; j++)
		{
			Log.d("Test", "i" +i);
		    l.insert(result[i++]);
		}
	}
	
	public int[] displayOnCard(List l)// method to display the elements of the list.
	{
		temp = l.head;
		int cardValues[] = new int[4];
		int index = 0;
		if(temp==null)
		{
			Log.d("Test", "Empty!?");
		}
		else
		{
			while(temp.right != l.head)
			{
				cardValues[index] = temp.info;
				temp=temp.right;
				index += 1;
			}
			cardValues[index] = temp.info; //prints the info of the last node.
		}
		
		return cardValues;
               
	}
	
	/*public boolean check(List l)
	    {
	    System.out.println("entered check");
	    int count =1;
	    boolean flag=false;
	     temp=l.head;
	    while(temp!=l.tail)
	    {
	        System.out.println("hello");
	 if(temp.info==temp.right.info)
	 {
	     count++;
	     temp=temp.right;
	
	 }
	        }
	        if (count == 4)
	     {
	         flag = true;
	        }
	     System.out.println("exited check");
	 return flag;
	
	}*/
	public int delete(int x, List l)
	{
	    System.out.println("entered delete");
	    temp=l.head.right;
		if(l.head.info==x)
		{
		    l.head=l.head.right;
		    l.head.left=l.tail;
		    l.tail.right=l.head;
		    //ll.insert(x);
		}
		else
		{
		    while( temp!=l.head&&temp.info!=x)
		    {
		        temp=temp.right;
		    }
		    if(temp.info==x)
		    {
		        if(temp.right==l.head)
		        {
		             l.tail=temp.left;
		        }
		        temp.left.right=temp.right;
		        temp.right.left=temp.left;
		    }
		    
		    temp = null;
		}
		
		return x;
	}
	
	
	public int shift(DNode insert,List l)
	{
	    int elem;
	  
	    if(insert.left.info==insert.info)
	    {
	        DNode q=temp=insert.right;
	        if( insert.left==l.head)
	        {
	        	while(temp.info==temp.right.info)
	        	{
	        		temp=temp.right;
	        	}
	        	q=temp.right;
	        }
	        elem=q.info;
	
	    }
	    else
	    {
	        elem=insert.info;
	    }

	    return elem;
	}

}


