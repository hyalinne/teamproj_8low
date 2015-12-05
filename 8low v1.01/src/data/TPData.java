package data;

import java.awt.Graphics;

public class TPData {
	private String name;	
	private TPData left;
	private TPData right;
	private int day;
	private int startTime;
	private int endTime;
	private int duringTime;
	private int x, y, width, height;
	
	public TPData() {
		this.name = null;
		this.left = null;
		this.right = null;
		this.day = 0;
		this.startTime = 0;
		this.endTime = 0;
		this.duringTime = 0;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}
	
	public TPData(String name, int day, int sTime, int eTime) {
		this.name = name;
		this.left = null;
		this.right = null;
		this.day = day;
		this.startTime = sTime;
		this.endTime = eTime;
		this.duringTime = eTime - sTime;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public TPData getLeft() {return left;}
	public void setLeft(TPData left) {this.left = left;}
	public TPData getRight() {return right;}
	public void setRight(TPData right) {this.right = right;}
	public int getDay() {return day;}
	public void setDay(int day) {this.day = day;}
	public int getStartTime() {return startTime;}
	public void setStartTime(int startTime) {this.startTime = startTime;}
	public int getEndTime() {return endTime;}
	public void setEndTime(int endTime) {this.endTime = endTime;}
	public int getDuringTime() {return duringTime;}
	public void setDuringTime(int duringTime) {
		this.duringTime = duringTime;
		this.endTime = this.startTime + this.duringTime;
	}
	
	public void setBounds(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	
	public void draw(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		g.drawString(this.name, this.x + 2, this.y + 5);
	}
	
	public boolean contain(int x, int y) {
		if((this.x <= x && x <= this.x + this.width) && (this.y <= y && y <= this.y + this.height)) {
			return true;
		}
		return false;
	}
}
