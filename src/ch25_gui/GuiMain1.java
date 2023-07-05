package ch25_gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain1 extends JFrame {
	
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GuiMain1 frame = new GuiMain1();
		frame.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public GuiMain1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); // (어느좌표에 뛰울것인지 가로 450 세로 300)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(131, 26, 176, 44);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JButton signinBtn = new JButton("Login");
		signinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				if(!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(contentPane, "사용자 정보가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE); // contentPane (창 안) 어느 지점에 뛰울것인가 , null 화면 중앙에 뛰운다.
					// 어디에 뛰울것인지, 내용, 제목, 아이콘
//					System.out.println("사용자 정보가 일치하지 않습니다."); // 무엇인가가 틀렸을 때 빠져 나가게 만든다.
					return;
				}
				
				JOptionPane.showMessageDialog(contentPane, "환영합니다.", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
			}
		});
		signinBtn.setBounds(131, 167, 176, 44);
		contentPane.add(signinBtn);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(131, 89, 176, 44);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
	}
}
