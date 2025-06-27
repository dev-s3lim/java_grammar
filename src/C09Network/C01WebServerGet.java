package C09Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");

        while (true) {
            Socket socket = serverSocket.accept(); /// 사용자의 요청이 담겨있음

            // 응답 메시지 구성
            String body = "hello world java";
            String response =
                    "HTTP/1.1 200 OKay\r\n" +
                            "Content-Type: text/plain; charset=UTF-8\r\n" +
                            "Content-Length: " + body.getBytes(StandardCharsets.UTF_8).length + "\r\n" +
                            "\r\n" +
                            body;

            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}