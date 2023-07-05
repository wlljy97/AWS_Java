package ch25_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;

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
		setBounds(100, 100, 450, 300);
		mainCardPane = new JPanel();
		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainCardPane);
		mainCardLayout = new CardLayout(0, 0);
		mainCardPane.setLayout(mainCardLayout);
		
		mainCardLayout.show(mainCardPane, getName());
		
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "name_805857088215800");
		subPanel1.setLayout(null);
		
		JButton subPanel2ShowBtn = new JButton("2번페이지");
		subPanel2ShowBtn.setBounds(315, 114, 97, 23);
		subPanel1.add(subPanel2ShowBtn);
		
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "name_805873924302900");
		subPanel2.setLayout(null);
		
		JButton subPanel1ShowBtn = new JButton("1번페이지");
		subPanel1ShowBtn.setBounds(12, 120, 97, 23);
		subPanel2.add(subPanel1ShowBtn);
		
		JButton subPanel3ShowBtn = new JButton("3번페이지");
		subPanel3ShowBtn.setBounds(315, 120, 97, 23);
		subPanel2.add(subPanel3ShowBtn);
		
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "name_805886794144700");
		subPanel3.setLayout(null);
		
		JButton subPanel2ShowBtn2 = new JButton("2번페이지");
		subPanel2ShowBtn2.setBounds(12, 120, 97, 23);
		subPanel3.add(subPanel2ShowBtn2);
		subPanel1.add(subPanel2ShowBtn);
		
	}

}
