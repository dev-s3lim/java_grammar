package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class C10BoardService1 {
    public static void main(String[] args) throws IOException {
        //1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//        2.회원 전체 목록 조회 : id, email
//        3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(할수있으면해보고)
//        4.게시글 작성 :title, content, 작성자Email(author객체가능)
//        5.게시물 목록 조회 : id(post), title
//        6.게시물 상세 조회(id로조회) : id(post), title, contents, 작성자email(작성자이름으로조회...쉬우면)
//        7.서비스 종료


//        구현 못한 것: 회원상세조회에서 작성글 수, 작성자이름을 받아서 게시물 상세조회

        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        loop1 : while (true) {

            System.out.println("1.회원가입 2.회원전체목록 3.회원상세조회 4.게시글작성 5.게시물목록조회 6.게시물상세조회 7.서비스종료");
            int selectNum = Integer.parseInt(br.readLine());

            if(selectNum == 1) {

                System.out.println("이름을 입력해주세요");
                String nameInput = br.readLine();
                System.out.println("이메일을 입력해주세요");
                String emailInput = br.readLine();
                for(Author a : authorList) {
                    if(a.getEmail().equals(emailInput)) {
                        System.out.println("이미 존재하는 이메일입니다.");
                        continue loop1;
                    }
                }
                System.out.println("비밀번호를 설정해주세요");
                String passwdInput = br.readLine();
                Author at = new Author(nameInput,emailInput,passwdInput);
                authorList.add(at);

            } else if(selectNum == 2) {

                System.out.println("회원전체목록");
                System.out.println("---------------------------");
                for(Author a : authorList) {
                    System.out.print("id : " + a.getAuthorId());
                    System.out.print(" / email : " + a.getEmail());
                    System.out.println();
                }
            }

            else if(selectNum ==3 ) {

                System.out.println("회원상세조회입니다.");
                System.out.println("이메일을 입력해주세요.");
                String authorEmailInput = br.readLine();

                boolean found = false;
                for(Author a : authorList) {
                    if(authorEmailInput.equals( a.getEmail())) {
                        System.out.println("ID : " + a.getAuthorId());
                        System.out.println("이메일 : " +a.getEmail());
                        System.out.println("이름 : " + a.getName());
                        System.out.println("비밀번호 : " + a.getPassword());
                        found = true;
                    }
                }

                if(found==false) {
                    System.out.println("존재하지 않는 이메일입니다.");
                    continue loop1;
                }
                int count = 0;
                for(Post p : postList) {
                    if(authorEmailInput.equals(p.getAuthor().getEmail())) {
                        count++;
                    }
                }
                System.out.println("작성글 수 : " + count);


            } else if(selectNum==4) {

                System.out.println("게시글 작성페이지");
                System.out.println("--------------------");
                System.out.println("제목을 입력해주세요");
                String titleInput = br.readLine();
                System.out.println("내용을 입력해주세요");
                String contentsInput = br.readLine();
                System.out.println("이메일을 입력해주세요");
                String emailInput = br.readLine();

                Author authorEmail = null;
                for(Author a : authorList) {
                    if(emailInput.equals(a.getEmail())) {
                        authorEmail = a;
                        break;
                    }
                }
                if(authorEmail == null) {
                    System.out.println("존재하지 않는 이메일입니다.");
                    continue loop1;
                }

                Post post = new Post(titleInput,contentsInput,authorEmail);
                postList.add(post);
                System.out.println("성공적으로 등록되었습니다.");

            } else if(selectNum == 5) {

                System.out.println("게시글목록조회");

                for(Post p : postList) {
                    System.out.print("ID:" + p.getAutoIncrementId());
                    System.out.println(" / 제목 : " + p.getTitle());
                }

            } else if(selectNum == 6) {
                System.out.println("게시글상세조회");

                for(Post p : postList) {

                    System.out.print("ID:" + p.getAutoIncrementId());
                    System.out.println(" / 제목 : " + p.getTitle());
                    System.out.println("내용 : " + p.getContents());
                    System.out.println("작성자 : " + p.getAuthor().getName());
                    System.out.println("--------------------------------");
                }

            } else if(selectNum == 7) {
                System.out.println("서비스 종료 하시겠습니까? 1:나가기 / 2:머무르기");
                int getOut = Integer.parseInt(br.readLine());

                if(getOut==1) {
                    break;
                }

            } else {
                System.out.println("올바른 값을 넣어주세요");
            }

        }

    }
}

class Author {
    private String name;
    private String email;
    private String password;
    static private int id = 0;
    private int authorId;

    public Author(String name, String email, String password) {
        id++;
        this.authorId = id; //모르는부분
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class Post{
    private String title;
    private String contents;
    private static int postId = 1;
    private int autoIncrementId;
    private Author author;

    public Post(String title, String contents, Author author) {
        this.title=title;
        this.contents=contents;
        this.autoIncrementId = postId;
        postId++;
        this.author = author;
    }
    public int getAutoIncrementId() {
        return autoIncrementId;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", autoIncrementId=" + autoIncrementId +
                ", author=" + author +
                '}';
    }
}


