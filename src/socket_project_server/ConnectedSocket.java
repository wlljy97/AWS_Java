package socket_project_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {
	
	private final Socket socket;
	private Gson gson;
	
	private String username;
	
	@Override
	public void run() {
		gson = new Gson();
		
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = (bufferedReader.readLine()); 
				
				requestController(requestBody);
		
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
			private void requestController(String requestBody) {
				
		}
	
}
