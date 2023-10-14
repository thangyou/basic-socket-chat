package JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame1 {

	public static void main(String[] args) {
		// JFrame : 화면을 구성하는 메인 프레임
		JFrame frame = new JFrame();
		// JPanel : JFrame 안에서 나누어지는 구역
		JPanel panel = new JPanel();
		// JLabel : 기능을 수행하는 컴포넌트
		// JFrame/JPanel에 JPanel/JLabel을 추가하는 함수
		panel.add(new JLabel("JFrame 실습"));
		frame.add(panel);
		
		frame.setVisible(true); // 컴파일 시 바로 보임
		frame.setSize(500, 500); // 화면 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 정상 종료
		frame.setLocationRelativeTo(panel); // 화면 중간에 생성
		frame.setResizable(false); // 화면 크기 조절 X
		
		
		
	}
}
