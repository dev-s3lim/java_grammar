package C09Network;

import java.sql.*;

public class C03DBConnect {
    public static void main(String[] args) throws SQLException {

//        mysql드라이버 별도 다운로드 및 추가
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, userName, password); /// 연결 객체
//        Statement객체에 쿼리를 담아 db에 전달
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from post where id=1");
//        rs.next()를 통해 데이터를 1 row씩 read
        while (rs.next()){ /// for문 index 도는 것 처럼 컬럼부터 채우고 한 라인씩 채운다고 보면됨 (jdbc -> 불편)
        /// 나중에는 이걸 객체로 만들어주는게 더 편하다.
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("title"));
            System.out.println(rs.getString("contents"));
        }

        connection.close();
    }
}
