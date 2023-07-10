package ch26_socket.server;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ConnectedClientController {
	
	private static ConnectedClientController instance;
	@Getter
	private List<ConnectedSocket> connectedSockets; // 변수 위에 Getter을 달면 다른곳에는 getter가 되지 않는다.
	
	private ConnectedClientController() {
		connectedSockets = new ArrayList<>(); // ConnectedSocket객체를 ArrayList에 담을 수 있다.
	}
	
	public static ConnectedClientController getInstace() {
		if(instance == null) {
			instance = new ConnectedClientController();
		}
		return instance;
	}
	
	
}
