package basic_cs_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server2 {
	public static String calc(String exp) {
		System.out.println("Server2 calc() : " + exp);

		StringTokenizer st = new StringTokenizer(exp, " ");
		if (st.countTokens() != 3)
			return "error";

		String result = "";
		int op1 = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());

		switch (opcode) {
		case "+":
			result = Integer.toString(op1 + op2);
			break;
		case "-":
			result = Integer.toString(op1 - op2);
			break;
		default:
			return "error";
		}
		System.out.println("Server2 result : " + result);
		return result;
	}

	public static void main(String[] args) throws IOException {
		ServerSocket listener2 = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			listener2 = new ServerSocket(9998);
			while (true) {
				System.out.println("Server2 연결을 기다리고 있습니다......");
				socket = listener2.accept();

				System.out.println("Server2 connected");

				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				String exp = in.readLine();
				System.out.println("Server1 -> 2 : " + exp);

				String result = calc(exp);

				out.write(result);
				out.newLine();
				out.flush();

				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
