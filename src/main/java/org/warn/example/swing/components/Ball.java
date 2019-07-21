package org.warn.example.swing.components;

import java.awt.Graphics;



public class Ball {

	private int x = 0;
    private int y = 0;
    private int width = 20;
    private int height = 20;
	
	public Ball() {
		
	}	
	
	protected void paintShape(Graphics g) {
		g.fillOval( x, y, width, height );
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
