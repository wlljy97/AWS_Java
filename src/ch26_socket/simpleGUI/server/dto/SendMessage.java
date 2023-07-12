package ch26_socket.simpleGUI.server.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SendMessage {
	
	private String fromUsername;
	private String toUsername; // 누가 보냈고 
	private String messageBody; // 어떤 메세지
	
}
