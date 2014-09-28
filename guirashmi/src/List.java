
public class List {


	 DNode head;
      DNode tail;
      DNode insert;
	public List()
	{
		head=null;
                tail=null;
                insert=null;
    }
public DNode insert(int k)//method to insert a node.
	{
    //System.out.println("entered insert");
		DNode node1= new DNode(k);
		if(head==null)//if the list is empty,the following block gets executed.
		{
			node1.left=node1.right=node1;
                        head=node1;
			tail=node1;
					}
		else if(node1.info<head.info)//if the priority of node1 is more than the priority of the first node, following block gets executed
		{
			node1.right=head;
                        node1.left=tail;
			head.left=node1;
			head=node1;
                        tail.right=head;
				}
		else
		{
			DNode temp=head;
			while(temp.right!=head&&temp.info<=node1.info)//traversing of the list till the appropriate position is reached
			{
				temp=temp.right;
			}
			if(temp.info>node1.info)//mid insertion takes place.
			{
				temp.left.right=node1;
				node1.left=temp.left;
				node1.right=temp;
				temp.left=node1;
			}
			else//end insertion takes place.
			{
				temp.right=node1;
					node1.left=temp;
					tail=node1;
                                        tail.right=head;
                                        head.left=tail;


			}
		}
                //System.out.println("exited insert");
                insert=node1;
                return node1;
	}
public boolean check()
    {
   // System.out.println("entered check");
    int count =1;
    boolean flag=false;
     DNode temp=head;
    while(temp!=tail)
    {
      //  System.out.println("hello");
 if(temp.info==temp.right.info)
 {
     count++;
            }
     temp=temp.right;

 
    }
        if (count == 4)
     {
         flag = true;
        }
     //System.out.println("exited check");
 return flag;

}
}



