package data;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TPButton extends JButton {
	private static final long serialVersionUID = 1L;
	
	private TPData myData;
	
	public TPButton() {
		super();
		this.setLayout(null);
		this.myData = null;
	}
	
	public TPData getData() {return myData;}
	public void setData(TPData data) {myData = data;}
	
	public void setLabel(String text) {
		JLabel temp = new JLabel(text);
		temp.setBounds(5,0,100,30);
		this.add(temp);
	}
}
