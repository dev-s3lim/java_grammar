package C07Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class C02File {
    public static void main(String[] args) throws IOException {
        /*
        /// 콘솔창에 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);


         */
        /*
        /// 파일에서 읽기 (IO 패키지를 통해) -> 성능 떨어짐 동기 -> 속도 느림 (StringBuffer)
        BufferedReader br2 = new BufferedReader(new FileReader("/Users/shlim/Desktop/16기/java_grammar/text.txt"));
        String line = br2.readLine();
        while (line != null){
            System.out.println(line);
            line = br2.readLine();
        }

         */

        /*
        /// 파일에서 읽기 (NIO 패키지를 통해) 비동기 -> 속도 빠름 (StringBuilder)
        Path filePath = Paths.get("/Users/shlim/Desktop/16기/java_grammar/text.txt");
        /// readString 문자열 전체를 통째로 읽는다.
        String st1 = Files.readString(filePath);
        System.out.println(st1);

        System.out.println();

        /// readAllLines 문자열을 라인별로 split -> List로 형태로 저장
        List<String> st2 = Files.readAllLines(filePath);
        System.out.println(st2);

        for (String l : st2){
            System.out.println(l);
        }

         */


        /// 파일 쓰기
        Path filePath = Paths.get("/Users/shlim/Desktop/16기/java_grammar/text1.txt");
        Files.write(filePath, "홍길동0\n".getBytes(), StandardOpenOption.CREATE_NEW); /// 새로입력 (파일을 만들면서 추가)
        Files.write(filePath, "홍길동1\n".getBytes(), StandardOpenOption.WRITE); /// 덮어쓰기
        Files.write(filePath, "홍길동2\n".getBytes(), StandardOpenOption.APPEND); /// 추가모드
    }
}
///serialize (직렬화)
///parsing (역직렬화)