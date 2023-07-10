package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	private final Socket socket; // 매개변수로 소켓 생성자를 만듬
	
	@Override
	public void run() {
		
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(bufferedReader.readLine());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
