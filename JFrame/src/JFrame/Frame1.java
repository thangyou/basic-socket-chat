package JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame1 {

	public static void main(String[] args) {
		// JFrame : ȭ���� �����ϴ� ���� ������
		JFrame frame = new JFrame();
		// JPanel : JFrame �ȿ��� ���������� ����
		JPanel panel = new JPanel();
		// JLabel : ����� �����ϴ� ������Ʈ
		// JFrame/JPanel�� JPanel/JLabel�� �߰��ϴ� �Լ�
		panel.add(new JLabel("JFrame �ǽ�"));
		frame.add(panel);
		
		frame.setVisible(true); // ������ �� �ٷ� ����
		frame.setSize(500, 500); // ȭ�� ũ��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷� ���� ����
		frame.setLocationRelativeTo(panel); // ȭ�� �߰��� ����
		frame.setResizable(false); // ȭ�� ũ�� ���� X
		
		
		
	}
}
