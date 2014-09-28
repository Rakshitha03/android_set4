/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class SingleList 
{
    Node head;
    String[] s=new String[10];
    public SingleList()
    {
    	System.out.println("Single list entered");
        head=null;
        instructions();
        
        for(int i=0; i<s.length; i++)
        {
        	end_insertion(s[i]);
        }
        display();
    }
    public void instructions()
    {
        s[0]="1. The game consists of 16 cards and 4 players, where you are the user.";
        s[1] ="2. On each card is printed a number: either 1,2,3 or 4. \n    These are NOT cards from the standard deck of 52 cards.";
        s[2]="3. Four cards will be randomly distributed to each player at the beginning of\n     a game.";
        s[3]="4. To win, you must make a set, i.e., you must hold four cards having the same \n     number(such as four 1s or four 2s etc.)";
        s[4]="5. Click on a card you do not want to make a set of. \n     This card will be passed to the player on your left.";
        s[5]="6. The next player will pass it to the player on his left and so on until you \n     receive a card from the player on your right.";
        s[6]="7. You may pass on the received card if you do not want it or choose to pass a \n    different card. Continue passing and receiving until there is a winner.";
        s[7]="8. Winner bags 10 points, losers lose 2 ";
        s[8]="9. By clicking on the 'Score' button, the scores of your previous game will be \n     displayed. ";
        s[9]="10.By clicking on the 'Play again' option, a new game begins, and the scores of \n      the previous game are saved ";
      
    }
      public void end_insertion(String s)
      {
         
		Node node1=new Node(s);
		if(head==null)
		{
			head=node1;
		}
		else
		{
			Node temp=head;
			while(temp.link!=null)
			{
				temp=temp.link;
			}
			temp.link=node1;
		
		}
	}

      public void display()// method to display the elements of the list.
	{
          //System.out.println("entered display");
		Node temp=head;
			while(temp.link!=null)
			{
				System.out.println(temp.key);
				temp=temp.link;
			}
	//System.out.println("exited display");	//prints the info of the last node.
		
               
	}
    
  }
