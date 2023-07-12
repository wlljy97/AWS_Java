package ch26_socket.simpleGUI.client;

import java.awt.CardLayout;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.TextField;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@Getter
public class SimpleGUIClient extends JFrame {
	 
	// 싱글톤 생성 한 이유 : 변수 또는 Thread에서 사용 하기 위해서,
	// 어디서든 호출 할 수 있게, 리턴값을 똑같이 받을 수 있게
	// static 으로 접근
	private static SimpleGUIClient instance;
	public static SimpleGUIClient getInstance() {
		if(instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}
	
	private String username;
	private Socket socket; // SimpleGUIClient 안에 socket이 들어가 있음
	
	private CardLayout mainCardLayout;
	private JPanel mainCardJPanel;
	
	private JPanel chattingRoomPanel;
	private JScrollPane roomListScrollPanel;
	private DefaultListModel<String> roomListModel;
	private JList roomList;
	
	private JPanel chattingRoomListPanel;
	private JTextField messageTextField;
	private JTextArea chattingTextArea; // 멤버 변수로 빼둠
	private JScrollPane userListScrollPane;
	private DefaultListModel<String> userListModel;
	private JList userList;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = SimpleGUIClient.getInstance(); // main에서 SimpleGUIClient 클래스가 생성
					// 싱글톤을 사용하여 getInstance 를 호출 // SimpleGUIClient.getInstance();객체를 생성
					frame.setVisible(true);
					
					ClientRecevier clientRecevier = new ClientRecevier();  // static 으로 접근해서 이 객체안에 들어있는 데이터를 getter로 받음
					// static 안에서는 멤버변수여서 생성된 frame을 이용해서 socket을 가져온다.
					clientRecevier.start();
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleGUIClient() { // 싱글톤 생성자는 private로 하여 외부에서 못가져가게 만듬
		
		username = JOptionPane.showInputDialog(chattingRoomPanel, "아이디를 입력하세요.");
			
		if(Objects.isNull(username)) {
			System.exit(0); // System.exit(0); 프로그램 종료
		}
		
		if(username.isBlank()) {
			System.exit(0);
		}
		
		try {
			socket = new Socket("127.0.0.1", 8000); // 생성되는 순간에 accept에서 반응한다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 639);
		
		mainCardLayout = new CardLayout();
		mainCardJPanel = new JPanel();
		mainCardJPanel.setLayout(mainCardLayout);
		setContentPane(mainCardJPanel);
		// 카드레이아웃을 쓰는 패널을 만듬
		
		chattingRoomListPanel = new JPanel();
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomListPanel.setLayout(null);
		mainCardJPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		
		
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(10, 10, 100, 30);
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방제목을 입력하세요.");
				if(Objects.isNull(roomName)) {
					return;
				}
				if(roomName.isBlank()) {
					JOptionPane.showMessageDialog(chattingRoomListPanel, "방제목을 입력하세요", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int i = 0; i < roomListModel.size(); i++) {
					if(roomListModel.get(i).equals(roomName)) {
						JOptionPane.showMessageDialog(chattingRoomListPanel, "이미 존재하는 방제목 입니다.", "방만들기 실패", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				mainCardLayout.show(mainCardJPanel, "chattingRoomPanel");
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);
			}
		});
		chattingRoomListPanel.add(createRoomButton);
		
		
		roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(10, 73, 410, 178);
		chattingRoomListPanel.add(roomListScrollPanel);
		
		
		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 ) { // getClickCount() 클릭 수 확인
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					mainCardLayout.show(mainCardJPanel, "chattingRoomPanel"); 
					
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		roomListScrollPanel.setViewportView(roomList);
		
		
		
		chattingRoomPanel = new JPanel();
		chattingRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPanel.setLayout(null);
		mainCardJPanel.add(chattingRoomPanel, "chattingRoomPanel");
		
		JScrollPane chattingTextAreaScrollPane = new JScrollPane();
		chattingTextAreaScrollPane.setBounds(12, 10, 250, 500);
		chattingRoomPanel.add(chattingTextAreaScrollPane);
		
		chattingTextArea = new JTextArea(); // JTextArea textArea = new JTextArea(); 지역 변수로 되어 있는 것을 위에 멤버변수로 빼둠
		chattingTextAreaScrollPane.setViewportView(chattingTextArea);
		
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendMessage sendMessage = SendMessage.builder()
							.fromUsername(username)
							.messageBody(messageTextField.getText())
							.build();
					
					RequestBodyDto<SendMessage> requestBodyDto = 
							new RequestBodyDto<>("sendMessage", sendMessage);
					
					ClientSender.getInstance().send(requestBodyDto); // send 메소드 안에 데이터를 보내겠
					messageTextField.setText(""); // 엔터를 쳤을 때 입력부분을 비워두게 하는
					
				}
			}
		});
		messageTextField.setBounds(12, 550, 412, 40);
		chattingRoomPanel.add(messageTextField);
		
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(308, 10, 114, 191);
		chattingRoomPanel.add(userListScrollPane);
		
		userListModel = new DefaultListModel<>(); // 위에서 String로 잡아놔서 String 으로 잡힘
		userList = new JList(userListModel);
		userListScrollPane.setViewportView(userList); // List 관리
		
		///   /////     ////   ////   /////// /////
		///
		
		
		
	}
}
