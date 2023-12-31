package socket_project_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {	
		
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println(" [서버실행] ");
			
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("접속");
				
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocketList.add(connectedSocket);
				
				connectedSocket.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
