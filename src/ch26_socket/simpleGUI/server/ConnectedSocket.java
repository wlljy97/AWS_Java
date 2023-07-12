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
	private Gson gson;
	
	private String username;
	
	@Override
	public void run() {
		gson = new Gson(); // run 메소드가 호출 되면 gson이 생성
		
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
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
			case "connection" :
				connection(requestBody); // 메소드 호출
				break;
		
			case "createRoom" :
				createRoom(requestBody);
				break;
		
			case "join" :
				join(requestBody);
				break;
		
			case "sendMessage" :
				sendMessage(requestBody);
				break;
				
			case "leave":
				leave();
				break;
		}
	}
	
	// 각각의 메소드 별로 관리
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = 
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		ServerSender.getInstance().send(socket, updateRoomListRequestBodyDto);
	}
	
	private void createRoom(String requestBody) {
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
	}
	
	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getRoomName().equals(roomName)) {
				room.getUserList().add(this);
				
				List<String> usernameList = new ArrayList<>();
				
				room.getUserList().forEach(con -> { // List를 반복 돌림
					usernameList.add(con.username);
				});
				
				room.getUserList().forEach(ConnectedSocket -> {
					RequestBodyDto<List<String>> updateUesrListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					ServerSender.getInstance().send(ConnectedSocket.socket, updateUesrListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(ConnectedSocket.socket, joinMessageDto);
					
				});
			}
		});
	}
	
	private void sendMessage(String requestBody) {
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<RequestBodyDto<SendMessage>>() {};
		
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody(); // sendMessage 객체로 변환
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getUserList().contains(this)) { // 나랑 동일한 객체가 있는지 확인을 한다. // 여기서 this는 connectedsocket
				room.getUserList().forEach(ConnectedSocket -> {
					RequestBodyDto<String> dto = 
							new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
					
					ServerSender.getInstance().send(ConnectedSocket.socket, dto);
				});
			}
		});
	}
	
	private void leave() {
		SimpleGUIServer.roomList.forEach(room -> {
			 if(room.getUserList().contains(this)) {
				room.getUserList().remove(this);
				
				List<String> usernameList = new ArrayList<>();
				
				room.getUserList().forEach(con -> {
					usernameList.add(con.username);
				});
				
				room.getUserList().forEach(ConnectedSocket -> {
	                RequestBodyDto<List<String>> updateUesrListDto = new RequestBodyDto<>("updateUserList", usernameList);
	                RequestBodyDto<String> leaveMessageDto = new RequestBodyDto<>("showMessage", username + "님이 나갔습니다.");

	                ServerSender.getInstance().send(ConnectedSocket.socket, updateUesrListDto);
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                ServerSender.getInstance().send(ConnectedSocket.socket, leaveMessageDto);
	            });
				
			}
		});
	}
	
}



// isNull : 전체 전송

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


