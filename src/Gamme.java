import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Gamme extends JPanel implements ActionListener, KeyListener,MouseMotionListener,  MouseListener{

	Player player=new Player(500,500,10,10);
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Buttonn clicky=new Buttonn(860,450,100,100);
	ObbjectManager manager=new ObbjectManager(player);
	Font titleFont=new Font("Arial",Font.PLAIN,24);
	static boolean alreadyRan=true;
	
	int clickedX;
	int clickedY;
	
	Timer timer;
	Timer enemyTimer;
	
	Gamme(){
		timer = new Timer(1000/60,this);
		enemyTimer = new Timer(1000 , manager);
	   
		
	}
	
	void startGame() {
		
		manager.addEnemy(new Enemy(20,20,10,10,1));
		manager.addEnemy(new Enemy(400,200,10,10,2));
		manager.addEnemy(new Enemy(800,400,10,10,3));
		
		
		
		

		
		 enemyTimer.start();
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		
		
		if(currentState==MENU_STATE) {
			updateMenuState();
		}
		else if(currentState==GAME_STATE) {
			updateGameState();
		}
		else if(currentState==END_STATE) {
			updateEndState();
		}
		
		
	}
	
void updateEndState() {

	}
void updateMenuState() {
	//if(clicky.clicked==true) {
	//	currentState=GAME_STATE;
	//	clicky.clicked=false;
	//}
	
}
	void updateGameState() {
		
		manager.update();
		if(player.isAlive==false) {
			currentState=END_STATE;
		}
		
		pause(4000);
		
	}
	
	
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("YOU HAVE LOST, PRESS THE BUTTON TO TRY AGAIN", 100, 100);
		clicky.draw(g);
	}
	
void drawGameState(Graphics g) {
	
		manager.draw(g);
		
	}

void drawMenuState(Graphics g) {
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("GET READY TO RUN", 100, 100);
	
	clicky.draw(g);
	
	
}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
			 
			 		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
			 
			 
		 
		 
		
		 
		
		
	}
	
	public void paintComponent(Graphics g){
		if(currentState==MENU_STATE) {
			drawMenuState(g);
		}
		else if(currentState==GAME_STATE) {
			drawGameState(g);
		}
		else if(currentState==END_STATE) {
			drawEndState(g);
		}
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(currentState==GAME_STATE) {
		System.out.println(e.getX()+", "+e.getY());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		clickedX=e.getX();
		clickedY=e.getY()-24;
		
		if(currentState==MENU_STATE&&clicky.checkClicked(clickedX, clickedY)) {
			currentState=GAME_STATE;
			clicky.clicked=false;
		}
		
		if(currentState==END_STATE&&clicky.checkClicked(clickedX, clickedY)) {
			player=new Player(500,500,10,10);
			 manager=new ObbjectManager(player);
			 currentState=0;
			
			 startGame();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		player.x=e.getX()-6;
		player.y=e.getY()-30;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		player.x=e.getX()-6;
		player.y=e.getY()-30;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		player.x=e.getX()-6;
		player.y=e.getY()-30;
	}
	
	public static void pause(int milli) {
		if(alreadyRan==false) {
			try {
				Thread.sleep(milli);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			alreadyRan=true;
			}
	}

	
	
}
