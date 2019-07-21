package org.warn.example.swing.components;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;



@SuppressWarnings("serial")
public class EditorPanel extends JPanel {

    private JTextPane textPane;
    private JPopupMenu menu;
    
    private int cursorXPos;
    private int cursorYPos;
	private String [] words = { "append", "apple", "application",  };
	
	public EditorPanel() {
		textPane = new JTextPane();
		textPane.setEditable(true);
		textPane.setPreferredSize( new Dimension( 700, 800 ) );
		textPane.setMinimumSize( new Dimension( 700, 800 ) );
		textPane.addKeyListener( new EditorKeyListener() );
		cursorXPos = 20;
		cursorYPos = 20;
		add(textPane);
	}
	
	
	
	class EditorKeyListener implements KeyListener {
		
		public void keyTyped(KeyEvent e) {
			
		}
		
		
		public void keyPressed( KeyEvent e ) {
			updateCusorPosition( e.getKeyCode() );
		}
		
		public void keyReleased(KeyEvent e) {
			
			if( menu != null ) {
				menu.requestFocus();
				menu.setVisible(false);
				menu = null;
			}
			
			String inputKey = String.valueOf( e.getKeyChar() );
			
			if( inputKey.matches("[A-Za-z]") || 
					inputKey.equals( "`" ) || 
					inputKey.equals( "~" ) || 
					inputKey.equals( "@" ) || 
					inputKey.equals( "^" ) || 
					inputKey.equals( "_" ) || 
					inputKey.equals( "[" ) || 
					inputKey.equals( "{" ) || 
					inputKey.equals( "]" ) || 
					inputKey.equals( "}" ) || 
					inputKey.equals( "\\" ) || 
					inputKey.equals( "|" ) || 
					inputKey.equals( "<" ) || 
					inputKey.equals( ">" ) ) {
				
				String lastWord =  getLastWord();
				//System.out.format("lastWord=%s \n", lastWord );
				
				if( lastWord.length() > 2 ) {
					
					for( String word: words ) {
						
						if( word.startsWith( lastWord ) ) {
							
							if( menu == null ) {
								menu = new JPopupMenu();
							}
							
							JMenuItem item = new JMenuItem( word );
							item.addActionListener( new MenuActionListener() );
							menu.add(item);
						}
					}
					
					if( menu != null ) {
						menu.show( e.getComponent(), cursorXPos, cursorYPos );
						textPane.requestFocus();
					}
					
				}
				
				System.out.format("-------------\n");
				
			}

		}
		
	}
	
	
	
	private String getLastWord() {
		String text = null;
		try {
			text = textPane.getDocument().getText( 0, textPane.getDocument().getLength() );
			text = replaceSpecialCharsWithSpaces( text );
			//System.out.format("text=|%s| \n", text );
			//System.out.format("text.length=%s \n", text.length() );
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}

		
		int wordStart = 0;
		int wordEnd = textPane.getSelectionEnd();
		//System.out.format("getSelectionEnd=%s, chartAt(wordEnd)=%s \n", wordEnd, text.charAt( wordEnd-1 ) );
		
		for( int i = wordEnd-1; i >= 0; i-- ) {
			
			if( text.charAt(i) == ' ' ) {
				wordStart = i;
				break;
			}
		}
		
		//System.out.format("wordStart=%s \n", wordStart );
		return text.substring( wordStart, wordEnd ).replaceAll(" ", "" );
	}
	
	
	private String replaceSpecialCharsWithSpaces( String text ) {
		
		text = text.replaceAll("\\d", " "); // replace digits
		text = text.replaceAll("\\W", " "); // replace non word characters (specials chars)
		text = text.replaceAll("\\s", " "); // replace white space characters
		return text;
	}
	
	
	
	
	private void updateCusorPosition(int keyCode) {
		
		System.out.println("keyCode=" + keyCode );
		
		if( keyCode == 9 ) { // tab
			cursorXPos -= 4;
			
		} else if( keyCode == 9 ) { // tab
			cursorXPos += 20;
			
		} else if( keyCode == 10 ) { // return carriage
			cursorXPos = 0;
			cursorYPos += 14;
			
		} else if( keyCode == 32 ) { // space
			cursorXPos += 2;
			
		} else {
			cursorXPos += 4;
		}
		System.out.println("cursorXPos=" + cursorXPos + ", cursorYPos=" + cursorYPos );
	}
	
	
	class MenuActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		}
		
	}
	
	
}
