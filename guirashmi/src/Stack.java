
public class Stack
{
	int[] stk=new int[100];
	int tos;
	public Stack()
	{
		tos=-1;
	}
	public void push(int item)
	{
		/*if(tos>100)
		System.out.println("Stack overflow");
		else
		{*/
			tos++;
			stk[tos]=item;
		//}
	}
	public int pop()
	{
		int x=stk[tos];
		tos--;
		return x;
		
	}
}