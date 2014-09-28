import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends javax.swing.JFrame implements ActionListener
{
	
	String winner;
	String values[];
	int p,q,r,s;
	
    void components()
    {
    	play = new javax.swing.JButton();
        exit = new javax.swing.JButton();      
        play.addActionListener(this);
        exit.addActionListener(this);
    }
   public Display(String s, int a, int b, int c, int d)
   {
		winner = s;
		p=a;
		q=b;
		r=c;
		this.s=d;
		values = new String[4];
		values[0] = Integer.toString(a);
		values[1] = Integer.toString(b);
		values[2] = Integer.toString(c);
		values[3] = Integer.toString(d);
		
   }
   
   public void paint(Graphics g) 
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setFont(new Font("Serif", Font.BOLD, 48));
      g2.setColor(Color.BLUE);
      
      paintHorizontallyCenteredText(g2, "GAME OVER", 200, 75);
      paintHorizontallyCenteredText(g2, winner, 200, 125);
      paintHorizontallyCenteredText(g2, "Wins!", 200, 175);
      paintHorizontallyCenteredText(g2, (values[0]), 200, 225);
      paintHorizontallyCenteredText(g2, (values[1]), 225, 225);
      paintHorizontallyCenteredText(g2, (values[2]), 250, 225);
      paintHorizontallyCenteredText(g2, (values[3]), 275, 225);
   }
   protected void paintHorizontallyCenteredText(Graphics2D g2,
   String s, float centerX, float baselineY) {
      FontRenderContext frc = g2.getFontRenderContext();
      Rectangle2D bounds = g2.getFont().getStringBounds(s, frc);
      float width = (float) bounds.getWidth();
      g2.drawString(s, centerX - width / 2, baselineY);
   }
   public void show()
   {
	 //  JPanel p=new JPanel();
     
     exit.setText("Exit");
     play.setText("Play");
     
		
      f.getContentPane().add(new Display(winner,p,q,r,s),BorderLayout.CENTER);
      JPanel panel = new JPanel();
      f.add(panel, BorderLayout.SOUTH);
      panel.add(exit);
      panel.add(play);
	  //f.setVisible(true); 
	   f.setSize(450, 350);
	   f.setVisible(true);
      
     // play.addActionListener(event);
      //ActionListener event = new ActionListener()
      
   }
   
@Override
public void actionPerformed(ActionEvent event)
{
	// TODO Auto-generated method stub
	Object obj= event.getSource();
	if(obj==play)
	{
		f.remove(this);
	}
	
}
private javax.swing.JButton play;
private javax.swing.JButton exit;
JFrame f = new JFrame();
   
}