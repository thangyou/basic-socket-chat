package basic_cs_socket;

import java.io.*;
import java.util.*;
import java.net.*;

// 수식을 입력받고 결과를 client로 전달하는 Server 
public class Server1 {
	public static String calc(String exp) throws IOException {
		String result = "";
		try {
			StringTokenizer st = new StringTokenizer(exp, " ");
			if (st.countTokens() != 3)
				return "error";
			st.nextToken(); // 첫번째꺼 버리고
			String opcode = st.nextToken(); // 두번째꺼만
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
			// 소켓연결
			listener = new ServerSocket(9999);

			System.out.println("연결을 기다리고 있습니다......");
			socket = listener.accept();
			System.out.println("연결되었습니다.");

			// 서버 인풋 아웃풋
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("end")) {
					System.out.println("Client에서 연결을 종료하였습니다.");
					break;
				}
				System.out.println("클라이언트 : " + inputMessage);
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
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
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
			System.out.println("서버 : " + result);

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
