+++++++++++++++++++++++++









package ch26_socket.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientApplication extends JFrame {

	private Socket socket; // Socket을 전역으로 빼둠 // 선언을 위에 해둠
	
	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField messageTextField;
	private JButton messageSendButton; // 밑에 선언해준것을 위에 선언 시킴

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 519);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		// <<< 채팅내용 출력 >>>
		JScrollPane chatTextAreaScrollPane = new JScrollPane();
		chatTextAreaScrollPane.setBounds(12, 10, 409, 398);
		mainPanel.add(chatTextAreaScrollPane);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setEditable(false); // 채팅을 하지 못하게 한다.
		chatTextAreaScrollPane.setViewportView(chatTextArea);
		
		// <<< 채팅연결 >>>
		ipTextField = new JTextField();
		ipTextField.setBounds(433, 13, 208, 27);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);
		
		portTextField = new JTextField();
		portTextField.setBounds(433, 50, 208, 27);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);
		
		JButton connectionButton = new JButton("접속");
		connectionButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) { // MouseEvent e 마우스를 통해서 이벤트를 받음
				
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();
				
				// 마우스가 올려졌을때
				if(serverIp.isBlank() || serverPort.isBlank()) {
					JOptionPane.showMessageDialog(
							mainPanel,
							"IP와 PORT번호를 입력해주세요.",
							"접속 오류",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					socket = new Socket(serverIp, Integer.parseInt(serverPort));
					JOptionPane.showMessageDialog(
							mainPanel,
							"서버와의 연결에 성공하였습니다.",
							"접속 완료",
							JOptionPane.PLAIN_MESSAGE);
					messageTextField.setEditable(true);
					messageSendButton.setEnabled(true);
					
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
					
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
			}
		});
		connectionButton.setBounds(433, 87, 208, 27);
		mainPanel.add(connectionButton);
		
		// <<< 접속자 >>>
		JScrollPane connectedUserListScrollPane = new JScrollPane();
		connectedUserListScrollPane.setBounds(433, 159, 208, 247);
		mainPanel.add(connectedUserListScrollPane);
		
		JList connectedUserList = new JList();
		connectedUserListScrollPane.setViewportView(connectedUserList);
		
		// <<< 메세지입력 및 전송 >>>
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { //enter가 일어났을때 전송을 시키겠다. // .VK_ENTER 상수값 10 ,\n으로 표시 되어있음
					System.out.println("전송");
				}
			}
		});
		messageTextField.setBounds(12, 418, 542, 52);
		messageTextField.setEditable(false); // setEditable 비활성화 // false 값을 넣어 입력을 못하게 함
		mainPanel.add(messageTextField);
		messageTextField.setColumns(10);
		
		messageSendButton = new JButton("전송"); // 선언을 밑에 해둠 // 선언을 위로 다시 두어서 비활성화를 품
		messageSendButton.setBounds(566, 416, 75, 54);
		messageSendButton.setEnabled(false); // setEnabled 비활성화 
		mainPanel.add(messageSendButton);
	}
}
