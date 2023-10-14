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
		
		// panel�� Layout ����
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
		frame.setVisible(true); // ������ �� �ٷ� ����
		frame.setSize(500, 500); // ȭ�� ũ��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷� ���� ����
		frame.setLocationRelativeTo(panel); // ȭ�� �߰��� ����
		frame.setResizable(false); // ȭ�� ũ�� ���� X
	}

}
