package org.warn.example.swing.components;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class CustomFrame {
	
	
	
	public CustomFrame() {
		
		JFrame frame = new JFrame( "Blah" );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize( new Dimension( 400, 400 ) );
		frame.setMinimumSize( new Dimension( 400, 400 ) );
		frame.add( new CustomePanel() );
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {

    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
    	
    	javax.swing.SwingUtilities.invokeLater( new Runnable() {
    		public void run() {
            	new CustomFrame();
            }
        });
    }
	

}
