package data;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class TPData implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private ImageIcon icon;
	
	private String address;
	private String phoneNum;
	private String content;
	
	private int startTime;
	private int x, y, width, height;
	
	public TPData() {
		this.name = null;
		this.address = null;
		this.phoneNum = null;
		this.content = null;
		this.startTime = 0;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}
	
	public TPData(String name, String theme) {
		this.name = name;
		this.address = null;
		this.phoneNum = null;
		this.content = null;
		this.startTime = 0;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		if(theme.equals("¸ÀÁý")) {
			icon = new ImageIcon("rsc/eatingBtn.jpg");
		} else if(theme.equals("°ü±¤")) {
			icon = new ImageIcon("rsc/seeingBtn.jpg");
		} else if(theme.equals("ÈÞ½Ä")) {
			icon = new ImageIcon("rsc/sleepingBtn.jpg");
		}
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public ImageIcon getIcon() {return icon;}
	public void setIcon(ImageIcon icon) {this.icon = icon;}

	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public int getStartTime() {return startTime;}
	public void setStartTime(int startTime) {this.startTime = startTime;}
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
