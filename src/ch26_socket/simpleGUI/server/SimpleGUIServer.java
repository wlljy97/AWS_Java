package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ch26_socket.simpleGUI.server.entity.Room;

public class SimpleGUIServer {
	
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	public static List<Room> roomList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("[ 서버실행 ]"); // 서버실행
			
			while(true) {
				Socket socket = serverSocket.accept(); // 서버 기다림
				System.out.println("접속");
				ConnectedSocket connectedSocket = new ConnectedSocket(socket); // ConnectedSocket 를 Thread로 만듬
				connectedSocketList.add(connectedSocket); // 각 Thread를 List에 넣어둠
				
				connectedSocket.start(); // start를 하면 socket의 run 부분이 돈다
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
