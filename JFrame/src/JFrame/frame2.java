package JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class frame2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("2nd frame");

		JTextField txtField = new JTextField();
		JTextArea txtArea = new JTextArea();
		JButton btn1 = new JButton("Click");
		JButton btn2 = new JButton("Exit");
		JPanel btnPanel = new JPanel();
		
		// panel에 Layout 세팅
		panel.setLayout(new BorderLayout());
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		panel.add(label, BorderLayout.NORTH);
		panel.add(btnPanel, BorderLayout.EAST);
		panel.add(txtArea, BorderLayout.CENTER);
		panel.add(txtField, BorderLayout.AFTER_LAST_LINE);

		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtField.setText(txtArea.getText());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		frame.add(panel);
		frame.setVisible(true); // 컴파일 시 바로 보임
		frame.setSize(500, 500); // 화면 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 정상 종료
		frame.setLocationRelativeTo(panel); // 화면 중간에 생성
		frame.setResizable(false); // 화면 크기 조절 X
	}

}
