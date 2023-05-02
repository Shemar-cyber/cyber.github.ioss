package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;

public class CalcuView extends JFrame {
	private JTextField textField;
	JButton offButton,btnOn,clearbtn, divideButton, Button7,Button8;
	JButton Button9, mulButton, Button4, Button5, button6, minusButton;
	JButton Button1, button2, button3, plusButton, button0, pointButton, equButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcuView frame = new CalcuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public CalcuView() {
		getContentPane().setBackground(new Color(240, 255, 255));
		setBackground(Color.DARK_GRAY);
		setTitle("Calculator ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 426);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBounds(12, 12, 325, 52);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		offButton = new JButton("OFF");
		//offButton.setBorder(new RoundBorder());
		offButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == offButton) {
					offButton.setEnabled(false);
					btnOn.setEnabled(true);
					clearbtn.setEnabled(false);
					divideButton.setEnabled(false);
					Button7.setEnabled(false);
					Button8.setEnabled(false);
					Button9.setEnabled(false);
					mulButton.setEnabled(false);
					Button4.setEnabled(false);
					Button5.setEnabled(false);
					button6.setEnabled(false);
					minusButton.setEnabled(false);
					Button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					plusButton.setEnabled(false);
					button0.setEnabled(false);
					pointButton.setEnabled(false);
					equButton.setEnabled(false);
				}
			}
		});
		offButton.setBounds(95, 76, 61, 38);
		getContentPane().add(offButton);
		
		
		
		btnOn = new JButton("ON");
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnOn) {
					btnOn.setEnabled(false);
					offButton.setEnabled(true);
					clearbtn.setEnabled(true);
					divideButton.setEnabled(true);
					Button7.setEnabled(true);
					Button8.setEnabled(true);
					Button9.setEnabled(true);
					mulButton.setEnabled(true);
					Button4.setEnabled(true);
					Button5.setEnabled(true);
					button6.setEnabled(true);
					minusButton.setEnabled(true);
					Button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					plusButton.setEnabled(true);
					button0.setEnabled(true);
					pointButton.setEnabled(true);
					equButton.setEnabled(true);
				}
			}
		});
		btnOn.setBounds(22, 76, 61, 38);
		getContentPane().add(btnOn);
		
		
		clearbtn = new JButton("C");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == clearbtn) {
					textField.setText(" ");
				}
			}
		});
		clearbtn.setFont(new Font("Dialog", Font.BOLD, 15));
		clearbtn.setBounds(166, 76, 61, 38);
		getContentPane().add(clearbtn);
		clearbtn.setEnabled(false);
		
		divideButton = new JButton("/");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == divideButton) {
					textField.setText( textField.getText() + "/");
				}
			}
		});
		divideButton.setFont(new Font("Dialog", Font.BOLD, 16));
		divideButton.setBounds(249, 76, 61, 38);
		getContentPane().add(divideButton);
		divideButton.setEnabled(false);
		
		Button7 = new JButton("7");
		Button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button7) {
					textField.setText(textField.getText() +"7");
				}
			}
		});
		Button7.setFont(new Font("Dialog", Font.BOLD, 17));
		Button7.setBounds(22, 147, 61, 38);
		getContentPane().add(Button7);
		Button7.setEnabled(false);
		
		Button8 = new JButton("8");
		Button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button8) {
					textField.setText(textField.getText() +"8");
				}
			}
		});
		Button8.setFont(new Font("Dialog", Font.BOLD, 17));
		Button8.setBounds(95, 147, 61, 38);
		getContentPane().add(Button8);
		Button8.setEnabled(false);
		
		Button9 = new JButton("9");
		Button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button9) {
					textField.setText(textField.getText() +"9");
				}
			}
		});
		Button9.setFont(new Font("Dialog", Font.BOLD, 17));
		Button9.setBounds(166, 147, 61, 38);
		getContentPane().add(Button9);
		Button9.setEnabled(false);
		
		mulButton = new JButton("*");
		mulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mulButton) {
					textField.setText(textField.getText() +"*");
				}
			}
		});
		mulButton.setFont(new Font("Dialog", Font.BOLD, 20));
		mulButton.setBounds(249, 147, 61, 38);
		getContentPane().add(mulButton);
		mulButton.setEnabled(false);
		
		Button4 = new JButton("4");
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button4) {
					textField.setText(textField.getText() +"4");
				}
			}
		});
		Button4.setFont(new Font("Dialog", Font.BOLD, 17));
		Button4.setBounds(22, 205, 61, 38);
		getContentPane().add(Button4);
		Button4.setEnabled(false);
		
		Button5 = new JButton("5");
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button5) {
					textField.setText(textField.getText() +"5");
				}
			}
		});
		Button5.setFont(new Font("Dialog", Font.BOLD, 17));
		Button5.setBounds(95, 205, 61, 38);
		getContentPane().add(Button5);
		Button5.setEnabled(false);
		
		button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button6) {
					textField.setText(textField.getText() +"6");
				}
			}
		});
		button6.setFont(new Font("Dialog", Font.BOLD, 17));
		button6.setBounds(166, 205, 61, 38);
		getContentPane().add(button6);
		button6.setEnabled(false);
		
		minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == minusButton) {
					textField.setText(textField.getText() +"-");
				}
			}
		});
		minusButton.setFont(new Font("Dialog", Font.BOLD, 30));
		minusButton.setBounds(249, 205, 61, 38);
		getContentPane().add(minusButton);
		minusButton.setEnabled(false);
		
		Button1 = new JButton("1");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Button1) {
					textField.setText(textField.getText() +"1");
				}
			}
		});
		Button1.setFont(new Font("Dialog", Font.BOLD, 17));
		Button1.setBounds(22, 269, 61, 38);
		getContentPane().add(Button1);
		Button1.setEnabled(false);
		
		button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button2) {
					textField.setText(textField.getText() +"2");
				}
			}
		});
		button2.setFont(new Font("Dialog", Font.BOLD, 17));
		button2.setBounds(95, 269, 61, 38);
		getContentPane().add(button2);
		button2.setEnabled(false);
		
		button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button3) {
					textField.setText(textField.getText() +"3");
				}
			}
		});
		button3.setFont(new Font("Dialog", Font.BOLD, 17));
		button3.setBounds(166, 269, 61, 38);
		getContentPane().add(button3);
		button3.setEnabled(false);
		
		plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == plusButton) {
					textField.setText(textField.getText() +"+");
				}
			}
		});
		plusButton.setFont(new Font("Dialog", Font.BOLD, 20));
		plusButton.setBounds(249, 269, 61, 38);
		getContentPane().add(plusButton);
		plusButton.setEnabled(false);
		
		button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button0) {
					textField.setText(textField.getText() +"0");
				}
			}
		});
		button0.setHorizontalAlignment(SwingConstants.LEFT);
		button0.setFont(new Font("Dialog", Font.BOLD, 17));
		button0.setBounds(22, 333, 134, 38);
		getContentPane().add(button0);
		button0.setEnabled(false);
		
		pointButton = new JButton(".");
		pointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == pointButton) {
					textField.setText(textField.getText() +".");
				}
			}
		});
		pointButton.setVerticalAlignment(SwingConstants.BOTTOM);
		pointButton.setFont(new Font("Dialog", Font.BOLD, 28));
		pointButton.setBounds(166, 333, 61, 38);
		getContentPane().add(pointButton);
		pointButton.setEnabled(false);
		
		equButton = new JButton("=");
		equButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		equButton.setFont(new Font("Dialog", Font.BOLD, 17));
		equButton.setBounds(249, 333, 61, 38);
		getContentPane().add(equButton);
		equButton.setEnabled(false);
	}
}
