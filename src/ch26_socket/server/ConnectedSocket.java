package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {
	
	private final Socket socket; 
	// 상수가 되어서 무조건 초기화가 생긴다. 
	// final를 선언하여 필수값을 지정 
	// final을 붙히면 매개변수가 잡힘
	
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		
		try {
			while(true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // InputStreamReader 입력을 기다림
				String requestBody = bufferedReader.readLine();
				System.out.println("입력데이터 : " + requestBody);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
}
