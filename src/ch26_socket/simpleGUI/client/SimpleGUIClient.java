package ch26_socket.simpleGUI.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class SimpleGUIClient extends JFrame {

	private String username;
	private Socket socket;
	
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUIClient frame = new SimpleGUIClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleGUIClient() {
		
		username = JOptionPane.showInputDialog(contentPane, "아이디를 입력하세요.");
			
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 410, 195);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
						printWriter.println(username + " : " + textField.getText()); // 서버로 날라간다.
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		textField.setBounds(12, 211, 412, 40);
		contentPane.add(textField);
	}
}
