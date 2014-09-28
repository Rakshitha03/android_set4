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

public class Game extends Activity{
	private boolean single = true;
	protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        startGame();
    
	}
	
	public void startGame()
	{
		Card cards = new Card();
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

