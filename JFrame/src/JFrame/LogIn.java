package JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame {

	public LogIn() {
		JPanel panel = new JPanel();
		JLabel ID = new JLabel("ID : ");
		JLabel password = new JLabel("Password : ");
		JTextField txtID = new JTextField(10);
		// textField지만 암호화됨
		JPasswordField txtPass = new JPasswordField(16);
		JButton btnLogin = new JButton("Login");
		
		panel.add(ID);
		panel.add(txtID);
		panel.add(password);
		panel.add(txtPass);
		panel.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = "ab";
				String Pass = "123";
				
				// JPasswordField.getPassword() return char[]
				String getPass = new String(txtPass.getPassword());
				
				if (ID.equals(txtID.getText()) && Pass.equals(getPass)) {
					JOptionPane.showMessageDialog(null, "Success to login");
				} else {
					JOptionPane.showMessageDialog(null, "Fail to login");					
				}
			}
		});
		
		// JFrame에 panel 추가
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		// main에서 Login() 자동 실행
		new LogIn();
	}

}
