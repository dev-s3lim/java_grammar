package C09Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class C04WebServerDb {
    public static void main(String[] args) throws IOException, SQLException {

//        mysql드라이버 별도 다운로드 및 추가
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, userName, password);
//        Statement객체에 쿼리를 담아 db에 전달
        Statement st = connection.createStatement();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1];
            String id = "";
            if (infos.contains("?")) {
                id = infos.split("=")[1];
            }
            /// 만약에 insert문이면 transaction 관리를 해야하기 때문에 수동으로 try-catch 해줘야함
            ResultSet rs = st.executeQuery("select * from post where id="+"\'"+id+"\'");
            String response = "HTTP/1.1 200 OKay\r\n\r\n";
            while (rs.next()){
                response+="id : ";
                response+=rs.getInt("id");
                response+=" title : ";
                response+=rs.getString("title");
                response+=" contents : ";
                response+=rs.getString("contents");
            }
            System.out.println(response);
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}

/// 1. 웹서버 : 포트 지정 -> get/post, parameter 추출 -> http response 규격
/// 2. DB연결 : 드라이버 다운로드 -> 쿼리를 문자열 형태로 직접 작성, DB 조회 결과 처리 -> ResultSet (커서; 포인터)