package mian;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
	
	private JFrame frame;
	private JTextField txtField;
	private JPanel panel;
	private JButton[] numButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[11];
	private JButton addbtn, subBtn, minBtn, divBtn, decbtn, offButton,btnOn;
	private JButton delbtn, equbtn, clrbtn, negbtn;
	
	double num1=0,num2=0,reslut=0;
	char operator;
	
	public Calculator() {
		initializeCom();
	}
	
	public void initializeCom() {
		frame = new JFrame("Calculator");
		frame.setSize(390,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setBackground(Color.blue);
		
		txtField= new JTextField();
		txtField.setBounds(45, 25, 300, 40);
		txtField.setEditable(false);
		txtField.setHorizontalAlignment(0);
		
		addbtn = new JButton("+");
		subBtn = new JButton("-");
		minBtn = new JButton("*");
		divBtn = new JButton("/");
		decbtn = new JButton(".");
		delbtn = new JButton("Delete");
		equbtn = new JButton("=");
		clrbtn = new JButton("Clear");
		negbtn = new JButton("(-)");
		btnOn  = new JButton("ON");
		offButton = new JButton("OFF");

		//add buttons to array
		functionButtons[0] = addbtn;
		functionButtons[1] = subBtn;
		functionButtons[2] = minBtn;
		functionButtons[3] = divBtn;
		functionButtons[4] = decbtn;
		functionButtons[5] = delbtn;
		functionButtons[6] = equbtn;
		functionButtons[7] = clrbtn;
		functionButtons[8] = negbtn;
		functionButtons[9] = btnOn;
		functionButtons[10] = offButton;
		
		
		//iterate through the button array
		for(int i = 0; i < 11; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setEnabled(false);
		}
		
		
		for(int i = 0; i < 10; i++) {
			numButtons[i]= new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].setFocusable(false);
			numButtons[i].setEnabled(false);
		}
		
		negbtn.setBounds(45, 400, 85, 50);
		negbtn.setEnabled(false);
		delbtn.setBounds(150, 400, 85, 50);
		delbtn.setEnabled(false);
		clrbtn.setBounds(260, 400, 85, 50);
		clrbtn.setEnabled(false);
		btnOn.setBounds(45, 465, 140, 50);
		btnOn.setEnabled(true);
		offButton.setBounds(200,465, 150, 50);
		offButton.setEnabled(false);
		
		panel = new JPanel();
		panel.setBounds(45,70, 300, 300);
		panel.setLayout(new GridLayout(4,4, 8,8));
		panel.setBackground(Color.gray);
		
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(addbtn);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subBtn);		
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(minBtn);
		panel.add(decbtn);
		panel.add(numButtons[0]);
		panel.add(equbtn);
		panel.add(divBtn);
		
		
		frame.add(btnOn);
		frame.add(offButton);
		frame.add(negbtn);
		frame.add(panel);
		frame.add(delbtn);
		frame.add(clrbtn);
		frame.add(txtField);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i= 0; i<10;i++) {
			if(e.getSource() == numButtons[i]) {
				txtField.setText(txtField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decbtn) {
			txtField.setText(txtField.getText().concat("."));
		}
		if(e.getSource() == addbtn) {
			num1 = Double.parseDouble(txtField.getText());
			operator = '+';
			txtField.setText("");
		}
		if(e.getSource() == subBtn) {
			num1 = Double.parseDouble(txtField.getText());
			operator = '-';
			txtField.setText("");
		}
		if(e.getSource() == minBtn) {
			num1 = Double.parseDouble(txtField.getText());
			operator = '*';
			txtField.setText("");
		}
		if(e.getSource() == divBtn) {
			num1 = Double.parseDouble(txtField.getText());
			operator = '/';
			txtField.setText("");
		}
		if(e.getSource() ==equbtn) {
			num2 = Double.parseDouble(txtField.getText());
			
			switch (operator) {
			case '+': 
				reslut = num1 + num2;
				break;
			case'-':
				reslut = num1 - num2;
				break;
			case '/': 
				reslut = num1 / num2;
				break;
			case '*': 
				reslut = num1 * num2;
				break;
			}
			txtField.setText(String.valueOf(reslut));
			num1= reslut;
		}
		if(e.getSource() == clrbtn) {
			txtField.setText("");
		}
		if(e.getSource() == delbtn) {
			String str = txtField.getText();
			txtField.setText("");
			for(int i= 0; i<str.length()-1; i++) {
				txtField.setText(txtField.getText()+str.charAt(i));
			}
		}
		if(e.getSource() == negbtn) {
			double temp = Double.parseDouble(txtField.getText());
			temp*=-1;
			txtField.setText(String.valueOf(temp));
		}
		
		if(e.getSource() == btnOn) {
			for(int i = 0; i < 11; i++) {
				functionButtons[i].setEnabled(true);
			}
			
			for(int i = 0; i < 10; i++) {
				numButtons[i].setEnabled(true);
			}
			btnOn.setEnabled(false);
			offButton.setEnabled(true);
		}
		
		if(e.getSource() == offButton) {
			for(int i = 0; i < 11; i++) {
				
				functionButtons[i].setEnabled(false);
			}
			
			
			for(int i = 0; i < 10; i++) {
				
				numButtons[i].setEnabled(false);
			}
			btnOn.setEnabled(true);
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}

	
}

