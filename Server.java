package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;
	private Socket socket;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	
	public Server() {
		 try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Server is listening on port 8888");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("New connection from " 
								  + socket.getInetAddress().getHostAddress());
				//serverHandler();
				Thread clientThread = new Thread(() -> {
					serverHandler(socket);
                });
                clientThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	The serverHandler() method is responsible for processing client requests.
	It continuously reads client requests in a loop until the client disconnects,
	and it sends the corresponding results back to the client. 
	The server can handle multiple clients concurrently by creating separate
	threads for each client connection.

	the server will continue listening for new client connections
	and handle multiple client requests one after the other without terminating the program.
	*/
	public void serverHandler(Socket socket) {
		try {
			 outStream = new ObjectOutputStream(socket.getOutputStream());
			inStream = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
			int num1 = (int) inStream.readObject();
			int num2 = (int) inStream.readObject();
			String op = (String) inStream.readObject();
			
			int result;
			
			switch(op) {
			case "plus":
				result = num1 + num2;
				break;
			case "minus":
				result = num1 - num2;
				break;
			case "multiply":
				result = num1 * num2;
				break;
			case "divide":
				result = num1 / num2;
				break;
			default:
				System.out.println("nothing found");
				throw new IllegalArgumentException("Invalid operation: " + op);
			}
			// send the result back to the client
			outStream.writeObject(result);
			outStream.flush();
			System.out.println("Result (" + num1 + " " + op + " " + num2 + ") sent to client.");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			// close the streams and the socket
			try {
				if (inStream != null) inStream.close();
				if (outStream != null) outStream.close();
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
           }
		}
	
	public static void main(String[] args) {
		new Server();
	}
	
	
	
	
	
	
	
	
	
}