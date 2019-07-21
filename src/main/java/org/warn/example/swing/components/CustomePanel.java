package org.warn.example.swing.components;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class CustomePanel extends JPanel {

	private Ball ball;
	
	public CustomePanel() {
		
		ball = new Ball();
		addMouseMotionListener( new CustomMouseMotionListener() );
	}
	
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawString("This is my custom Panel!",10,20);
        ball.paintShape(g);
    }  
	
	
	private void moveSquare(int x, int y) {
		// Current square state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = ball.getX();
        final int CURR_Y = ball.getY();
        final int CURR_W = ball.getWidth();
        final int CURR_H = ball.getHeight();
        final int OFFSET = 0;

        if ((CURR_X!=x) || (CURR_Y!=y)) {

            // The square is moving, repaint background 
            // over the old square location. 
        	repaint( CURR_X, CURR_Y, CURR_W+OFFSET, CURR_H+OFFSET );

            // Update coordinates.
            ball.setX(x);
            ball.setY(y);

            // Repaint the square at the new location.
            repaint( ball.getX(), ball.getY(), ball.getWidth()+OFFSET, ball.getHeight()+OFFSET );
        }
    }
	
	
	
	class CustomMouseMotionListener implements MouseMotionListener {
		
		public void mouseDragged(MouseEvent e) {
			moveSquare(e.getX(),e.getY());
		}

		public void mouseMoved(MouseEvent e) {
			moveSquare(e.getX(),e.getY());
		}
		
	}
	
}
