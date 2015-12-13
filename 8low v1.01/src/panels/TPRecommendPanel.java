package panels;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Choice;

import constants.TPConstants;
import data.EEatingData;
import data.ESeeingData;
import data.ESleepingData;

public class TPRecommendPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel preNameLabel;
	private JLabel preAddressLabel;
	private JLabel prePhoneNumLabel;
	private JLabel preContentLabel;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel phoneNumLabel;
	private JLabel contentLabel;

	public TPRecommendPanel() {
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setLocation(0,TPConstants.MAIN_BUTTON_HEIGHT);
		this.setSize(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT);
		
		this.preNameLabel = new JLabel("ÀÌ¸§ : ");
		this.preNameLabel.setBounds(50, 300, 80, 40);
		this.preNameLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.PLAIN, 15));
		this.add(preNameLabel);
		this.preAddressLabel = new JLabel("ÁÖ¼Ò : ");
		this.preAddressLabel.setBounds(50, 340, 80, 40);
		this.preAddressLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.PLAIN, 15));
		this.add(preAddressLabel);
		this.prePhoneNumLabel = new JLabel("ÀüÈ­¹øÈ£ : ");
		this.prePhoneNumLabel.setBounds(50, 380, 80, 40);
		this.prePhoneNumLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.PLAIN, 15));
		this.add(prePhoneNumLabel);
		this.preContentLabel = new JLabel("»ó¼¼ : ");
		this.preContentLabel.setBounds(50, 420, 80, 40);
		this.preContentLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.PLAIN, 15));
		this.add(preContentLabel);
		
		this.nameLabel = new JLabel();
		this.nameLabel.setBounds(90, 300, 600, 40);
		this.nameLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 15));
		this.add(nameLabel);
		this.addressLabel = new JLabel();
		this.addressLabel.setBounds(90, 340, 600, 40);
		this.addressLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 15));
		this.add(addressLabel);
		this.phoneNumLabel = new JLabel();
		this.phoneNumLabel.setBounds(115, 380, 600, 40);
		this.phoneNumLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 15));
		this.add(phoneNumLabel);
		this.contentLabel = new JLabel();
		this.contentLabel.setBounds(90, 420, 600, 40);
		this.contentLabel.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 15));
		this.add(contentLabel);
		
		
		Choice choice = new Choice();
		choice.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 13));
		choice.setBounds(25, 126, 176, 312);
		choice.add("************°ü±¤************");
		for(ESeeingData data : ESeeingData.values()) {
			choice.add(data.getData().getName());
		}
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for(ESeeingData data : ESeeingData.values()) {
					if(data.getData().getName().equals(e.getItem().toString())) {
						nameLabel.setText(data.getData().getName());
						addressLabel.setText(data.getData().getAddress());
						phoneNumLabel.setText(data.getData().getPhoneNum());
						contentLabel.setText(data.getData().getContent());
						repaint();
					}
				}
			}
		});
		add(choice);
		
		Choice choice1 = new Choice();
		choice1.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 13));
		choice1.setBounds(270, 126, 176, 312);
		choice1.add("************À½½Ä************");
		for(EEatingData data : EEatingData.values()) {
			choice1.add(data.getData().getName());
		}
		choice1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for(EEatingData data : EEatingData.values()) {
					if(data.getData().getName().equals(e.getItem().toString())) {
						nameLabel.setText(data.getData().getName());
						addressLabel.setText(data.getData().getAddress());
						phoneNumLabel.setText(data.getData().getPhoneNum());
						contentLabel.setText(data.getData().getContent());
						repaint();
					}
				}
			}
		});
		add(choice1);
		
		Choice choice2 = new Choice();
		choice2.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 13));
		choice2.setBounds(525, 126, 176, 312);
		choice2.add("************ÈÞ½Ä************");
		for(ESleepingData data : ESleepingData.values()) {
			choice2.add(data.getData().getName());
		}
		choice2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for(ESleepingData data : ESleepingData.values()) {
					if(data.getData().getName().equals(e.getItem().toString())) {
						nameLabel.setText(data.getData().getName());
						addressLabel.setText(data.getData().getAddress());
						phoneNumLabel.setText(data.getData().getPhoneNum());
						contentLabel.setText(data.getData().getContent());
						repaint();
					}
				}
			}
		});
		add(choice2);
		
	}
	
	public void init() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		ImageIcon image = new ImageIcon("rsc/Recommendbg.png");
		super.paint(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}  
}