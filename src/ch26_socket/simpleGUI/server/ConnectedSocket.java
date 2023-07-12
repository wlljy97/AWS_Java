package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	private final Socket socket; // 매개변수로 소켓 생성자를 만듬
	private String username;
	
	@Override
	public void run() {
		
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = (bufferedReader.readLine()); // readLine 각각의 socket에 대해 읽고있음
				
				requestController(requestBody);
				
				
//				SimpleGUIServer.connectedSocketList.forEach(ConnectedSocket -> {
//					try {
//						PrintWriter printWriter = 
//								new PrintWriter(ConnectedSocket.socket.getOutputStream(), true);
//						printWriter.println(requestBody);
//						
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				});
//				// 반복을 돌릴 때 마다 Thread가 바뀌어서 socket도 바뀜
							
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
			case "connection" :
				username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				break;
		
			case "createRoom" :
				String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				
				Room newRoom = Room.builder()
					.roomName(roomName)
					.owner(username)
					.userList(new ArrayList<ConnectedSocket>())
					.build();
				
				SimpleGUIServer.roomList.add(newRoom);
				
				List<String> roomNameList = new ArrayList<>();
				
				SimpleGUIServer.roomList.forEach(room -> {
					roomNameList.add(room.getRoomName());
				});
				
				RequestBodyDto<List<String>> updateRoomListRequestBodyDto = 
						new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
				
				SimpleGUIServer.connectedSocketList.forEach(con -> {
					
					ServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
					
				});
				
				break;
		
			case "join" :
				
				SimpleGUIServer.connectedSocketList.forEach(ConnectedSocket -> {
					List<String> usernameList = new ArrayList<>();
					
					SimpleGUIServer.connectedSocketList.forEach(con -> { // List를 반복 돌림
						usernameList.add(con.username);
					});
					
					RequestBodyDto<List<String>> updateUesrListDto = new RequestBodyDto<List<String>>("updateUesrList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					ServerSender.getInstance().send(ConnectedSocket.socket, updateUesrListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(ConnectedSocket.socket, joinMessageDto);
					
				});
				
				break;
		
			case "sendMessage" :
				TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<RequestBodyDto<SendMessage>>() {};
				
				RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
				SendMessage sendMessage = requestBodyDto.getBody(); // sendMessage 객체로 변환
				
				SimpleGUIServer.connectedSocketList.forEach(ConnectedSocket -> {
					RequestBodyDto<String> dto = 
							new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
					
					ServerSender.getInstance().send(ConnectedSocket.socket, dto);
				});
				
				break;
				
		}
	}
}
// isNull 전체 전송

//				ServerSender.getinstance().send(socket, null); // toUser가 없으면 모두에게 보내는 것 있으면 해당하는 것에 보냄
// 								↑여기서 socket부분은 지정해서 보내는 부분

//		데이터
//	바디 - (요청) 데이터가 들어감
// 	헤더 - 정보가 들어감

//		SimpleGUIServer.connectedSocketList.forEach(ConnectedSocket -> {
//		}); // 람다식, forEach문
//		for(ConnectedSocket connectedSocket : SimpleGUIServer.connectedSocketList) {
//		} // 향상된 for문
//		for(int i = 0; i < SimpleGUIServer.connectedSocketList.size(); i++) {
//		} // for문
// 		위 3개의 반복문은 같은 것이다.


