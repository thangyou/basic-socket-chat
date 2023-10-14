package basic_cs_socket;

import java.io.*;
import java.util.*;
import java.net.*;

// ������ �Է¹ް� ����� client�� �����ϴ� Server 
public class Server1 {
	public static String calc(String exp) throws IOException {
		String result = "";
		try {
			StringTokenizer st = new StringTokenizer(exp, " ");
			if (st.countTokens() != 3)
				return "error";
			st.nextToken(); // ù��°�� ������
			String opcode = st.nextToken(); // �ι�°����
			switch (opcode) {
			case "+":
			case "-":
				return connectSocket(9998, exp);
			case "*":
			case "/":
				return connectSocket(9997, exp);
			default:
				return "error";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			// ���Ͽ���
			listener = new ServerSocket(9999);

			System.out.println("������ ��ٸ��� �ֽ��ϴ�......");
			socket = listener.accept();
			System.out.println("����Ǿ����ϴ�.");

			// ���� ��ǲ �ƿ�ǲ
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("end")) {
					System.out.println("Client���� ������ �����Ͽ����ϴ�.");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ : " + inputMessage);
				String outputMessage = calc(inputMessage);

				out.write(outputMessage + "\n");
				out.flush();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				in.close();
				out.close();

				socket.close();
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");
			}
		}
	}

	private static String connectSocket(int port, String input) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;

		String result = null;
		try {
			socket = new Socket("localhost", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.write(input);
			out.newLine();
			out.flush();
			result = in.readLine();
			System.out.println("���� : " + result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (Exception e) {
			}
		}
		return result;
	}
}
