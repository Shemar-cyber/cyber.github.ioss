package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ONOFF extends JFrame {

	private JPanel contentPane;
	private JButton offbtn;
	private JButton onbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ONOFF frame = new ONOFF();
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
	public ONOFF() {
		setTitle("MODE SWITCH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(117, 10, 208, 53);
		contentPane.add(lblNewLabel);
		
		onbtn = new JButton("ON");
		onbtn.setBackground(Color.white);
		onbtn.setFocusable(false);
		onbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==onbtn) {
					onbtn.setForeground(Color.white);
					contentPane.setBackground(getForeground());
					onbtn.setBackground(getForeground());
					lblNewLabel.setText("NIGHT MODE");
					lblNewLabel.setForeground(Color.white);
					offbtn.setForeground(Color.white);
					offbtn.setBackground(getForeground());
					getContentPane().add(offbtn);
					getContentPane().add(lblNewLabel);
					getContentPane().add(onbtn);
				}
			}
		});
		onbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		onbtn.setBounds(75, 73, 181, 41);
		contentPane.add(onbtn);
		
		offbtn = new JButton("OFF");
		offbtn.setBackground(Color.white);
		offbtn.setFocusable(false);
		offbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == offbtn) {
					onbtn.setForeground(Color.black);
					contentPane.setBackground(Color.white);
					onbtn.setBackground(Color.white);
					lblNewLabel.setText("LIGHT MODE");
					lblNewLabel.setForeground(Color.black);
					offbtn.setForeground(Color.black);
					offbtn.setBackground(Color.white);
					getContentPane().add(offbtn);
					getContentPane().add(lblNewLabel);
					getContentPane().add(onbtn);
				}
			}
		});
		offbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		offbtn.setBounds(77, 151, 179, 41);
		contentPane.add(offbtn);
	}
}
