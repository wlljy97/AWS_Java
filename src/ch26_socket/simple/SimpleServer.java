package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleServer {
	
	public static void main(String[] args) {
		try {
			System.out.println("서버실행");
			ServerSocket serverSocket = new ServerSocket(8000);
			List<Socket> socketList = new ArrayList<>();
			
			while(true) {
				Socket socket = serverSocket.accept(); // 클라이언트 접속을 기다림
				socketList.add(socket);
				
				Thread thread = new Thread(() -> {
					Socket threadSocket = socket;
					while(true) {
						System.out.println("데이터 입력 기다림.");
						BufferedReader bufferedReader;
						try {
							InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
							bufferedReader = new BufferedReader(inputStreamReader);
							String requestBody = bufferedReader.readLine();
							
							socketList.forEach(s -> {
								try {
									PrintWriter printWriter = new PrintWriter(s.getOutputStream(), true);
									printWriter.println("메세지내용 (" + requestBody +")");
									
								} catch (IOException e) {
									e.printStackTrace();
								}
								
							});
							
							
							// read int값은 유니코드를 가져온다, 모든입력이 따로 들어온다.
							// 한번에 쓰기 위해서는 bufferedReader가 필요함 
							// bufferedReader는 Reader 객체를 필요로 한다.
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				
				thread.start();
				
			}
				
			} catch (IOException e) {
				
		}
	}
}
