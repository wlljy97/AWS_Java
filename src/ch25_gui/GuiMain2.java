package ch25_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain2 extends JFrame {

	private JPanel mainCardPane;
	private CardLayout mainCardLayout; // 변수 선언
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain2 frame = new GuiMain2();
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
	public GuiMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 281);
		
		
		/* <<< mainCardPane >>> */
		mainCardPane = new JPanel();
		mainCardLayout = new CardLayout(0, 0); 
		
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 테두리를 의미
		mainCardPane.setLayout(mainCardLayout);

		setContentPane(mainCardPane); // 껍데기(setContentPane) 안의 메인 패널을 넣음
		
		
		/* <<< subCardPane1 >>> */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1"); //  여기서 "subPanel1" 은 키값
		subPanel1.setLayout(null);
		
		JButton subPanel2ShowBtn = new JButton("2번페이지"); // 버튼 생성
		subPanel2ShowBtn.setBounds(315, 120, 97, 23); // 위치 지정
		subPanel1.add(subPanel2ShowBtn); // 해당 버튼 추가
		
		subPanel2ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2"); 
				
			}
		});
		
		/* <<< subCardPane2 >>> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);
		
		JButton subPanel1ShowBtn = new JButton("1번페이지");
		subPanel1ShowBtn.setBounds(12, 120, 97, 23);
		subPanel2.add(subPanel1ShowBtn);
		
		subPanel1ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel1"); 
				
			}
		});
		
		JButton subPanel3ShowBtn = new JButton("3번페이지");
		subPanel3ShowBtn.setBounds(315, 120, 97, 23);
		subPanel2.add(subPanel3ShowBtn);
		
		subPanel3ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel3"); 
				
			}
		});
		
		/* <<< subCardPane3 >>> */
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);
		
		JButton subPanel2ShowBtn2 = new JButton("2번페이지");
		subPanel2ShowBtn2.setBounds(12, 120, 97, 23);
		subPanel3.add(subPanel2ShowBtn2);
		subPanel1.add(subPanel2ShowBtn);
		
		subPanel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2"); 
				
			}
		});
		
	}

}
