package racing.jaca;

//the IMPORTS needed for this assignment// 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;


public class Racing {
	
	// Variables for the the JFrame, JLable and the progress bar for each horse //
	JFrame frame;
	JProgressBar horse1 = new JProgressBar (0,100);
	JProgressBar horse2 = new JProgressBar (0,100);
	JProgressBar horse3 = new JProgressBar (0,100);
	JProgressBar horse4 = new JProgressBar (0,100);
	JProgressBar horse5 = new JProgressBar (0,100);

	JLabel msg = new JLabel ("");
	
	static boolean runRaceButtonIsPressed = false;  
	static boolean resetRaceButtonIsPressed = false;
	static boolean winner = false;
	static int winningHorse = 0;

	// The variables for the scores//
	int h1win = 0;
	int h2win = 0;
	int h3win = 0;
	int h4win = 0;
	int h5win = 0;

	// the variable for the users Horse pick //
    String UsersHorse;
   
	

	{ // this is the code for the first welcome message box//
		
		  UIManager.put("OptionPane.background",Color.BLACK); 
	      UIManager.put("Panel.background",Color.PINK); 
	    	 
		JOptionPane.showMessageDialog(null, "Hi Welcome to the Horse Race, here worlds five fastest horses are going race and you own one of the horses.    " + "\n" +
	   "You can continue playing the game as many times as you want! CLICK OK WHEN YOU ARE READY TO PLAY     ");
		 
		
	
		// this is the code for the input box where the users can pick the horse they want to play as//
	
		UIManager.put("OptionPane.background",Color.BLACK);
		UIManager.put("Panel.background",Color.GREEN); 
		
	 	UsersHorse = JOptionPane.showInputDialog( "\n" + " The  5 horse in this race are.... " + "\n" + " Horse 1 = Cisco" + "\n" + " Horse 2 = Jasper"
	 			+ "\n" + " Horse 3 = Naila" + "\n" +  " Horse 4 = Blue" + "\n" +  " Horse 5 (is you) = name of your choice " + "\n" +  
	 			" You are horse 5 Enter a name for your horse.          " + "\n \n");

	}
  
	
		
	public synchronized void finish (int i) { 	//the finish Method its synchronized, (the message that shows up after each race announcing the winner) //

	   
		msg.setVisible (true);
		msg.setText("Horse #" + winningHorse + " WON THIS ROUND!!!. To continue playing you can press Reset Race and then Run Race. ");
		
		
		if (i==100) {
			winner = true;
		    System.out.println("Horse #" + winningHorse + " WON!!! ");			
			
		}

	 frame.getContentPane().add(msg);
	
}
	
	
	
// main method runs the race//
	
	public static void main (String[] args ) { //main method//
		
		EventQueue.invokeLater (new Runnable() {

			public void run() {
				try {
					Racing window = new Racing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  }			
			
		});
		
	} //END MAIN//
	

	public Racing () { //Horse race constructor//
		initialize ();
	
	}
	
	
	
private void initialize () { // code to add the JFrame and other things on to it//
		
		frame = new JFrame(); //JFrame
		frame.setBounds(125,95,1060,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane () . setLayout(null);
						
		
		horse1.setStringPainted(true);;  //horse 1 progress bar//
		horse1.setString("Horse 1 ( Cisco )");
		horse1.setBounds(110,149,835,14);
		frame.getContentPane () .add(horse1);
		
		horse2.setStringPainted(true);;  //horse 2 progress bar//
		horse2.setString("Horse 2 ( Jasper )");
		horse2.setBounds(110,189,835,14);
		frame.getContentPane () .add(horse2);
		
		horse3.setStringPainted(true);;  //horse 3 progress bar//
		horse3.setString("Horse 3 ( Naila )");
		horse3.setBounds(110,229,835,14);
		frame.getContentPane () .add(horse3);
		
		horse4.setStringPainted(true);;  //horse 4 progress bar//
		horse4.setString("Horse 4 ( Blue )");
		horse4.setBounds(110,269,835,14);
		frame.getContentPane () .add(horse4);
		
		horse5.setStringPainted(true);;  //horse 5 progress bar//
		horse5.setString("Horse 5 ( " + UsersHorse + " )");  
		horse5.setBounds(110,309,835,14);
		frame.getContentPane () .add(horse5);
		
	
		msg.setBounds(200,110,700,14);   //message for who won the race//
		msg.setVisible(false);
		frame.getContentPane().add(msg);
				
		
		
		//Code for the 3 buttons on the screen (Run, Reset and Quit)//
		
		JButton btnStart = new JButton ("Run Race");
		btnStart.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		btnStart.addActionListener(new RunRace());
		btnStart.setBounds(290,370,155,40);
		btnStart. setBackground(Color. GREEN); 
		btnStart. setOpaque(true);
		frame.getContentPane() .add(btnStart);
		
		JButton btnReset = new JButton ("Reset Race");
		btnReset.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		btnReset.addActionListener(new ResetRace ());
		btnReset.setBounds(455,370,155,40);
		btnReset. setBackground(Color. GREEN); 
		btnReset. setOpaque(true);
		frame.getContentPane() .add(btnReset);
		
		JButton btnQuit = new JButton ("Quit Game");
		btnQuit.setFont(new Font ("Tahoma", Font.PLAIN, 18));
		btnQuit.addActionListener(new  QuitGame ());
		btnQuit.setBounds(620,370,155,40);
		btnQuit. setBackground(Color. GREEN); 
		btnQuit. setOpaque(true);
		frame.getContentPane() .add(btnQuit);
		
	
		// the Title//
		JButton TITLE = new JButton (" THE HORSE RACE!!");
		TITLE.setFont(new Font ("Tahoma", Font.PLAIN, 30));
		TITLE. setBackground(Color. RED); 
		TITLE.setBounds(385,15,300,64);
		TITLE. setOpaque(true);
		frame.getContentPane() .add(TITLE);	
		
		
		// code for adding the horse images (5 of them) //
		
		JButton h1 = new JButton ("Cisco");
		h1.setIcon(new ImageIcon("horse_PNG.png"));
		h1.setBounds(50,450,159,94);
		h1. setBackground(Color. BLACK); 
		h1. setOpaque(true);
		frame.getContentPane() .add(h1);
		
		JButton h2 = new JButton ("Jasper");
		h2.setIcon(new ImageIcon("h2.png"));
		h2.setBounds(250,450,159,94);
		h2. setBackground(Color. BLACK); 
		h2. setOpaque(true);
		frame.getContentPane() .add(h2);
		
		JButton h3 = new JButton ("Naila");
		h3.setIcon(new ImageIcon("h3.png"));
		h3.setBounds(450,450,159,94);
		h3. setBackground(Color. BLACK); 
		h3. setOpaque(true);
		frame.getContentPane() .add(h3);
		
		JButton h4 = new JButton ("Blue");
		h4.setIcon(new ImageIcon("h4.png"));
		h4.setBounds(650,450,159,94);
		h4. setBackground(Color. BLACK); 
		h4. setOpaque(true);
		frame.getContentPane() .add(h4);
		
		JButton h5 = new JButton ( UsersHorse );
		h5.setIcon(new ImageIcon("h5.png"));
		h5.setBounds(850,450,159,94);
		h5. setBackground(Color. BLACK); 
		h5. setOpaque(true);
		frame.getContentPane() .add(h5);
		
	}
		



// the 3 inner classes for the Run, Reset and Quit buttons //

class RunRace implements ActionListener { // this class starts the race and runs the 5 horses//
	
	public void actionPerformed(ActionEvent Args0) {
		if(!runRaceButtonIsPressed) {
			msg.setVisible (false);
			resetRaceButtonIsPressed = false;
			runRaceButtonIsPressed = true;
			
			H1 horse1 =new H1 ();
			horse1.start();
			
			H2 horse2 =new H2 ();
			horse2.start();
			
			H3 horse3 =new H3 ();
			horse3.start();
			
			H4 horse4 =new H4 ();
			horse4.start();
			
			H5 horse5 =new H5 ();
			horse5.start();
			
		}
		
	}
}


class ResetRace implements ActionListener { // This class resets all the horses so that it can be replayed//
	
	public void actionPerformed(ActionEvent Args0) {
		if(!resetRaceButtonIsPressed) {
			msg.setVisible (false);
			resetRaceButtonIsPressed = true;
			runRaceButtonIsPressed = false;
			winner = false;
			
			H1 h1 =new H1 ();
			h1.reset();
			
			H2 h2 =new H2 ();
			h2.reset();
			
			H3 h3 =new H3 ();
			h3.reset();
			
			H4 h4 =new H4 ();
			h4.reset();
			
			H5 h5 =new H5 ();
			h5.reset();
			
		}
		
	}
}


class QuitGame implements ActionListener { // This is for the quit button, and when its pressed the scores will pop up before the tab closes//
	
	public void actionPerformed(ActionEvent Args0) {
			
	     UIManager.put("Panel.background",Color.PINK); 
	      
	     JOptionPane.showMessageDialog(null, "\n  FINAL SCORES FOR THE HORSE RACE: (You were horse " + UsersHorse + " ).      \n \n"  + "  Horse 1 won " + h1win + " times \n" + "  Horse 2 won " + h2win + " times \n" +			  
				"  Horse 3 won " + h3win + " times \n" + "  Horse 4 won " + h4win + " times \n" + "  Horse 5 (YOU) won " + h5win  + " times \n" );
	     
			
		System.exit(0);
			
		
	}
	
}
   



//// the inner thread classes for each progress bar//

class H1 extends Thread {
	public void reset () { //reset method sets the progress bars to 0//
		horse1.setValue(0);
		horse1.repaint();
	}
	
	public void run() { //run method//
		for (int i = 0; i<101 ; i++ ) {
			if(winner) {
				break;
			}
			
			horse1.setValue(i);
			horse1.repaint();
			if (i==100) { //the horse that reach 100 first is determined the winning horse//
				winningHorse=1;
				h1win++;
				finish(i);

			}
			
			try { //the randomizer//
				Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60 );
			} catch (InterruptedException err) {
				err.printStackTrace();
			}
		}
	}
}


class H2 extends Thread {
	public void reset () {
		horse2.setValue(0);
		horse2.repaint();
	}
	
	public void run() {
		for (int i = 0; i<101 ; i++ ) {
			if(winner) {
				break;
			}
			
			horse2.setValue(i);
			horse2.repaint();
			if (i==100) {
				winningHorse=2;
			    h2win++;
				finish(i);

			}
			
			try {
				Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60 );
			} catch (InterruptedException err) {
				err.printStackTrace();
			}
		}
	}
}


class H3 extends Thread {
	public void reset () {
		horse3.setValue(0);
		horse3.repaint();
	}
	
	public void run() {
		for (int i = 0; i<101 ; i++ ) {
			if(winner) {
				break;
			}
			
			horse3.setValue(i);
			horse3.repaint();
			if (i==100) {
				winningHorse=3;
				 h3win++;
				finish(i);

			}
			
			try {
				Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60 );
			} catch (InterruptedException err) {
				err.printStackTrace();
			}
		}
	}
}


class H4 extends Thread {
	public void reset () {
		horse4.setValue(0);
		horse4.repaint();
	}
	
	public void run() {
		for (int i = 0; i<101 ; i++ ) {
			if(winner) {
				break;
			}
			
			horse4.setValue(i);
			horse4.repaint();
			if (i==100) {
				winningHorse=4;
				h4win++;
				finish(i);

			}
			
			try {
				Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60 );
			} catch (InterruptedException err) {
				err.printStackTrace();
			}
		}
	}
}


class H5 extends Thread {
	public void reset () {
		horse5.setValue(0);
		horse5.repaint();
	}
	
	public void run() {
		for (int i = 0; i<101 ; i++ ) {
			if(winner) {
				break;
			}
			
			horse5.setValue(i);
			horse5.repaint();
			if (i==100) {
				winningHorse = 5;
				h5win++;
				finish(i);

			}
			
			try {
				Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60 );
			} catch (InterruptedException err) {
				err.printStackTrace();
			}
		}
	}

}
}



			





	

	   