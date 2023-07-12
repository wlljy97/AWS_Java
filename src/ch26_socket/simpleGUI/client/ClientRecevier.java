package ch26_socket.simpleGUI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import lombok.RequiredArgsConstructor;

public class ClientRecevier extends Thread {
	
//	private final Socket socket; // 싱글톤으로 불러옴
	
	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance(); 
		// SimpleGUIClient.getInstance(); 자주 사용할 것 같으니 객체로 만듬
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(simpleGUIClient.getInstance().getSocket().getInputStream()));
				String requestBody = bufferedReader.readLine();
//				simpleGUIClient.getTextArea().append(requestBody + "\n"); // .append 문자열에다가 추가
				
				requestController(requestBody);
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
			case "updateRoomList" :
				List<String> roomList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getRoomListModel().clear();
				SimpleGUIClient.getInstance().getRoomListModel().addAll(roomList);
				break;
		
			case "showMessage" : // textArea 에 문자를 쭉쭉 써준다.
				String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getChattingTextArea().append(messageContent + "\n");
				break;
				
			case "updateUserList" :
				List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getUserListModel().clear(); // addElement List의 제일 끝에 달림
				SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList); 
				break;
		}
	}
	
	private void updateRoomList(String requsetBody) {
		
	}
	
	private void showMessage(String requestBody) {
		
	}
	
	private void updateUserList(String requestBody) {
		
	}
	
}
