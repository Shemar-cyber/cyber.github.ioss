package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	
	private Socket socket;
	private ServerSocket serverSocket;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	private JTextField textFieldresult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 136, 36);
		contentPane.add(lblNewLabel);
		
		textField1 = new JTextField();
		textField1.setBounds(100, 10, 232, 33);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number 2:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 54, 87, 19);
		contentPane.add(lblNewLabel_1);
		
		textField2 = new JTextField();
		textField2.setBounds(100, 56, 232, 27);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JRadioButton plusRadioButton = new JRadioButton("Plus");
		plusRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plusRadioButton.setBounds(6, 100, 78, 21);
		contentPane.add(plusRadioButton);
		
		JRadioButton minRadioButton = new JRadioButton("Minus");
		minRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minRadioButton.setBounds(86, 100, 87, 21);
		contentPane.add(minRadioButton);
		
		JRadioButton multiRadioButton = new JRadioButton("Multiply");
		multiRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		multiRadioButton.setBounds(175, 100, 87, 21);
		contentPane.add(multiRadioButton);
		
		JRadioButton divRadioButton = new JRadioButton("Divide");
		divRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		divRadioButton.setBounds(271, 100, 83, 21);
		contentPane.add(divRadioButton);
		
		JButton calButton = new JButton("Calculate");
		
		calButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		calButton.setBounds(155, 189, 177, 40);
		contentPane.add(calButton);
		
		ButtonGroup btngroup = new ButtonGroup();
		btngroup.add(plusRadioButton);
		btngroup.add(minRadioButton);
		btngroup.add(multiRadioButton);
		btngroup.add(divRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("Result :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 137, 74, 24);
		contentPane.add(lblNewLabel_2);
		
		textFieldresult = new JTextField();
		textFieldresult.setBounds(100, 142, 232, 27);
		contentPane.add(textFieldresult);
		textFieldresult.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_1) {
					textField1.setText("");
					textField2.setText("");
					textFieldresult.setText("");
					btngroup.clearSelection();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(23, 189, 123, 40);
		contentPane.add(btnNewButton_1);
		
		 try {
			 
		     socket = new Socket ("127.0.0.1", 8888);
		     System.out.println("Connected to server at " + socket.getInetAddress().getHostAddress() 
		    		 			+ ": Port: " + socket.getPort());
			
		     outStream = new ObjectOutputStream(socket.getOutputStream());
			 
		     inStream = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 calButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == calButton) {
	                    String num1 = textField1.getText();
	                    String num2 = textField2.getText();

	                    if (isValidNumber(num1) && isValidNumber(num2)) {
	                        int number1 = Integer.parseInt(num1);
	                        int number2 = Integer.parseInt(num2);
	                        String operation = "";

	                        if (plusRadioButton.isSelected()) {
	                            operation = "plus";
	                        } else if (minRadioButton.isSelected()) {
	                            operation = "minus";
	                        } else if (multiRadioButton.isSelected()) {
	                            operation = "multiply";
	                        } else if (divRadioButton.isSelected()) {
	                            operation = "divide";
	                        }
	                        
	                        try {
	                            // Send data to the server
	                            outStream.writeObject(number1);
	                            outStream.writeObject(number2);
	                            outStream.writeObject(operation);
	                            outStream.flush();

	                            // Receive result from the server
	                            int result = (int) inStream.readObject();
	                            textFieldresult.setText(String.valueOf(result));
	                            System.out.println("Result received from the server: " + result);
	                        } catch (IOException | ClassNotFoundException ex) {
	                            ex.printStackTrace();
	                        }
	                    } else {
	                        System.out.println("Invalid input");
	                    }
					}
				}
			});
	}
	
	private boolean isValidNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
}
}
