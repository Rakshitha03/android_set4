package com.example.set4v1;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Game extends Activity{
	private Card cards = new Card();
	private boolean won = false;
	private boolean single = true;
	protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        startGame();
    
	}
	
	public void startGame()
	{
		
		cards.generate_random();
		cards.create_Lists(cards.l1);
		cards.create_Lists(cards.l2);
		cards.create_Lists(cards.l3);
		cards.create_Lists(cards.l4);
		int cardVals[] = cards.displayOnCard(cards.l1);
		Button card1 = (Button) findViewById(R.id.button1);
		Button card2 = (Button) findViewById(R.id.button2);
		Button card3 = (Button) findViewById(R.id.button3);
		Button card4 = (Button) findViewById(R.id.button4);
		card1.setText(Integer.toString(cardVals[0]));
		card2.setText(Integer.toString(cardVals[1]));
		card3.setText(Integer.toString(cardVals[2]));
		card4.setText(Integer.toString(cardVals[3]));
	}
	
	public void changePic(View view) 
	{
	    final Button b = (Button)view;
	    String buttonText = b.getText().toString();
	    
	    int id = b.getId();
	    int val = Integer.parseInt(buttonText);
	    b.setText("");
		 int del;
			    //while(true)
			 	if(won!=true)
			    {
			        //System.out.println("enter number to be deleted");
			    	
			        cards.delete(val,cards.l1);
			        cards.l2.insert(val);
			       //cards.display(cards.l2);
			        del=cards.shift(cards.l2.insert, cards.l2);
			        if(cards.l2.check())
			        {
			        	Toast.makeText(getApplicationContext(), "Player2 Won!!", 
			        			   Toast.LENGTH_LONG).show();
			        }
			        cards.delete(del, cards.l2);
			        cards.l3.insert(del);
			        
			       
			        del=cards.shift(cards.l3.insert, cards.l3);
			        if(cards.l3.check())
			        {
			        	Toast.makeText(getApplicationContext(), "Player3 Won!!", 
			        			   Toast.LENGTH_LONG).show();
			        }
			        cards.delete(del, cards.l3);
			        cards.l4.insert(del);
			        //cards.display(cards.l3);
			      
			        del=cards.shift(cards.l4.insert, cards.l4 );
			        if(cards.l4.check())
			        {
			        	Toast.makeText(getApplicationContext(), "Player4 Won!!", 
			        			   Toast.LENGTH_LONG).show();
			        }
			        cards.delete(del, cards.l4);
			        cards.l1.insert(del);
			        //cards.display(cards.l4);
			        //tempstore[id-1]=String.valueOf(del);
			         buttonText = String.valueOf(del);
			         
			        //System.out.println("Th deleted value is "+del);
			      
			        //card.display(card.l1);
			      
			    //cards.display(cards.l1);
			    //cards.display(cards.l2);
			    //card.display(card.l3);
			    //card.display(card.l4);
			         //Checking if a set has been formed in any of the players!! 
			         
			   
			 }

		if(single == true)
		{
			ImageView pl2 = (ImageView)findViewById(R.id.ImageView02);
       	 	pl2.setImageResource(R.drawable.joker);

			CountDownTimer timer1;
			final CountDownTimer timer2;
			final CountDownTimer timer3;
			
			timer3 = new CountDownTimer(1000, 100) 
		    {
		         ImageView pl4 = (ImageView)findViewById(R.id.ImageView01);
		         
		         public void onTick(long millisUntilFinished) 
		         {
		             Log.d("Test", "Ticking");
		         }
		         public void onFinish() 
		         {
		        	 pl4.setImageResource(R.drawable.card);
		        	 int cardVals[] = cards.displayOnCard(cards.l1);
		     		Button card1 = (Button) findViewById(R.id.button1);
		     		Button card2 = (Button) findViewById(R.id.button2);
		     		Button card3 = (Button) findViewById(R.id.button3);
		     		Button card4 = (Button) findViewById(R.id.button4);
		     		card1.setText(Integer.toString(cardVals[0]));
		     		card2.setText(Integer.toString(cardVals[1]));
		     		card3.setText(Integer.toString(cardVals[2]));
		     		card4.setText(Integer.toString(cardVals[3]));
		     		if(cards.l1.check())
			        {
			        	Toast.makeText(getApplicationContext(), "You Won!!", 
			        			   Toast.LENGTH_LONG).show();
			        }
		        	 
		        	 
		         }
		    };
			
			timer2 = new CountDownTimer(1000, 100) 
		    {
				 ImageView pl4 = (ImageView)findViewById(R.id.ImageView01);
		         ImageView pl3 = (ImageView)findViewById(R.id.imageView1);
		         public void onTick(long millisUntilFinished) 
		         {
		             Log.d("Test", "Ticking");
		         }
		         public void onFinish() 
		         {
		        	 pl3.setImageResource(R.drawable.card);
		        	 pl4.setImageResource(R.drawable.joker);
		        	 timer3.start();
		         }
		    };
				
			timer1 = new CountDownTimer(1000, 100) 
		    {
				ImageView pl3 = (ImageView)findViewById(R.id.imageView1);
		        ImageView pl2 = (ImageView)findViewById(R.id.ImageView02);
		         public void onTick(long millisUntilFinished) 
		         {
		             Log.d("Test", "Ticking");
		         }
		         public void onFinish() 
		         {
		        	 pl2.setImageResource(R.drawable.card);
		        	 pl3.setImageResource(R.drawable.joker);
		        	 timer2.start();
		         }
		    }.start();
		}	
		
		else
		{
			Log.d("Test", "To fill");
			// find next person to pass to and change his card face to joker
		}
	}
}

