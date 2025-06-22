package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//        1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//        2.회원 전체 목록 조회 : id, email
//        3.회원 상세 조회 (id 조회) : id, email, name, password, 작성글 수 (***각 객체에 공용의 리스트를 두어*** list.size())
//        4.게시글 작성 : 제목, 내용, 작성자 Email (Author 객체 가능)
//        5.게시물 목록 조회 (id 조회) : id(post), title
//        6.게시물 상세 조회 (id 조회) : id(post), title, contents, 작성자 email(or 작성자 이름)
//        7.서비스 종료

public class C10BoardService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Author> authorList = new ArrayList<>(); //게시판 사이트 회원(Author)의 정보 집합을 수록할 리스트 준비
        List<Post> postList = new ArrayList<>(); //그 회원들이 쓸 글의 정보 집합을 수록할 리스트도 준비

        while(true){ // 이제부터 나오는 코드들은 반복해라...
            System.out.println("OO웹입니다. 요청하실 서비스 번호를 입력해주세요.");
            System.out.println(
                "1.회원가입\n" +
                "2.회원 전체 목록 조회\n" +
                "3.회원 상세 조회\n" +
                "4.게시글 작성\n" +
                "5.게시물 목록 조회\n" +
                "6.게시물 상세 조회\n" +
                "7.서비스 종료"
            );

            String request = br.readLine();
            if (request.equals("1")){
                System.out.println("OO웹입니다. 성함, 이메일, 비밀번호를 입력해주세요.");

                String[] regInfo = br.readLine().split(" ");

                String name = regInfo[0];
                String email = regInfo[1];
                String password = regInfo[2];

                Author iniReg = new Author(); // 아래 Author 클래스를 기반으로 새로운 회원 객체(iniReg)를 하나 생성
                iniReg.registration(name, email, password);
                // 생성된 iniReg 객체에 대해 Author 하위의 registration() 메서드를 호출하여...
                // name, email, password 값을 iniReg라는 필드에 초기화
                // 즉, 생성한 객체에 값을 채우는 것임
                authorList.add(iniReg); // 이후, 회원가입 정보가 수집된 iniReg객체를 Author 리스트에 저장

                System.out.println("\n" + "***********************************************");
                System.out.println(iniReg.getName() +"님, 회원가입을 축하드립니다! ");
                System.out.println(iniReg.getEmail() + " 이메일 계정으로 회원가입이 완료되었습니다.");
                System.out.println("***********************************************" + "\n");
            }
            else if (request.equals("2")){
                System.out.println("[관리자 전용] 전체 회원 조회 : ");

                for (Author check : authorList){
                    System.out.println(check.getId() + "번 회원 : " + check.getEmail());
                }
            }
            else if (request.equals("3")){
                System.out.println("[관리자 전용] 회원 상세조회 ***고유 id 번호 입력 요망*** : ");
                int idInput = Integer.parseInt(br.readLine());

                for (Author check : authorList){
                    // authorList에 저장된 Author의 객체들을 하나씩 꺼내보면서...
                    // 꺼낸 객체를 check라는 변수로 참조하며 아래를 반복
                    // 즉, 회원 목록 전체를 '순회'하며 특정 조건(email 등)에 맞는 회원을 찾기 위함
                    if (idInput == check.getId()){
                        // 사용자가 입력한 id 값(idInput)과
                        // 현재 순회 중인 Author 객체의 id 값(check.getId())이 같다면,
                        // 아래와 같이 해당 회원의 상세 정보를 출력
                        System.out.println("\n" + "======================================");
                        System.out.println("성명 : " + check.getName());
                        System.out.println("이메일 : " + check.getEmail());
                        System.out.println("암호 : " + check.getPassword());
                        System.out.println("작성글 수 : " );
                        System.out.println("***********************************************" + "\n");
                    }
                }
            }
            else if (request.equals("4")){
                System.out.println("OO웹 게시판입니다.");
                System.out.println("게시물의 제목, 내용, 그리고 이메일을 입력해주세요.");

                String[] writerInfo = br.readLine().split(" ");
                String title = writerInfo[0];
                String contents = writerInfo[1];
                String email = writerInfo[2];

                Author writer = null;  // 일단 변수 선언 (글쓴이가 아직 누군지는 모름)
                for (Author a : authorList){ // 회원 목록(authorList)에서 하나씩 Author 객체(a)를 꺼내서 검사
                    if (a.getEmail().equals(email)){ // 회원 리스트 중에서 입력받은 이메일과 같은 이메일을 가진 회원이 있다면...
                        writer = a; //일치하는 Author 객체를 writer라는 변수에 저장
                        break; // 찾았으니 for문 종료
                    }
                }

                if (writer != null){ // 이메일로 찾은 회원(writer)이 실제로 존재하면...
                    Post p = new Post(); // 새로운 Post(게시글) 객체 p를 하나 생성
                    p.write(writer, title, contents); // 방금 생성한 게시글 p에 작성자, 제목, 내용을 기록
                    postList.add(p); // 전체 게시글 목록(postList)에 이 게시글을 추가
                    writer.getPostList().add(p); // 이 글을 작성한 writer의 개인 게시글 목록(postList)에도 같은 게시글 추가
                    // writer는 Author 클래스의 객체이며,
                    // Author 클래스는 여러 개의 게시글(Post)을 담을 수 있는 리스트 필드인 postList를 가지고 있음
                    System.out.println("글이 성공적으로 게시되었습니다."+"\n");
                }
            }
            else if (request.equals("5")){
                System.out.println("전체 게시물 조회 : ");

                for (int i = 0; i < postList.size(); i++) { // 그냥 i (index) 값을 postId로 활용하기 위해 일반 for문 사용
                    Post p = postList.get(i); // postList 리스트에서 i번째에 있는 Post 객체를 꺼내서 p라는 변수에 담아라...
                    System.out.println("[게시글 " + (i + 1) + "] 제목: " + p.getTitle() + ", 작성자: " + p.getAuthor().getName());
                }
            }
            else if (request.equals("6")) {
                System.out.println("상세 게시물 조회 : ");
                System.out.print("조회하실 작성자 id 번호를 입력해주세요 : ");

                int authorId = Integer.parseInt(br.readLine());

                // 회원 목록에서 ID에 해당하는 작성자 찾기
                Author targetAuthor = null;
                for (Author a : authorList) {
                    if (a.getId() == authorId) {
                        targetAuthor = a;
                        break;
                    }
                }

                if (targetAuthor == null) {
                    System.out.println("해당 ID의 회원이 존재하지 않습니다.");
                    return;
                }

                // 해당 작성자의 게시물 리스트 가져오기
                List<Post> posts = targetAuthor.getPostList();

                if (posts.isEmpty()) {
                    System.out.println(targetAuthor.getName() + "님은 아직 작성한 게시물이 없습니다.");
                } else {
                    System.out.println("\n" + targetAuthor.getName() + "님의 게시물 목록");
                    System.out.println("***********************************************");
                    for (Post p : posts) {
                        System.out.println("제목: " + p.getTitle());
                        System.out.println("내용: " + p.getContents());
                        System.out.println("작성자 이메일: " + targetAuthor.getEmail());
                        System.out.println("-----------------------------------------------");
                    }
                    System.out.println("***********************************************\n");
                }
            }
            else if (request.equals("7")){
                System.out.println("OO웹 서비스를 이용해주셔서 감사합니다.");
                break;
            }
        }
    }

/// 클래스
static class Author{
    List<Post> postList = new ArrayList<>(); // -> Author은 Post에 여러 게시물을 쓸수 있는 (1:N) 관계이기 때문에 그 게시물을 담을 list가 필요
    // 위와 같이 구성하면 메인에서 선언된 각 Author 객체들이 postList를 가지게 되므로 유저 개개인이 쓴 글을 관리할 수 있음
    /// 객체 --------------------------
    private String name;
    private String email;
    private String password;
    private int id;
    /// 메서드 --------------------------
    private static int nextId = 1; //*static인 이유 -> 모든 객체가 공유해야하는 값이어야 하기 때문

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void registration (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = nextId++; // 파라미터에서 id를 받지 않기 때문에 메인에서 직접 설정은 불가하고...
                            // getId()로 조회만 가능
                            // nextId는 메서드 밖의 클래스 영역의 전역 변수로서,
                            // Main에서 각 객체가 생성될 때마다 자동으로 1씩 증가하며 고유 id를 부여한다.
    }
}

    static class Post {
        private Author author;
        private String title;
        private String contents;

        public void setAuthor(Author author) {
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        // 작성자 가져오기
        public Author getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getContents() {
            return contents;
        }

        // 게시글 작성
        public void write(Author author, String title, String contents) {
            this.author = author;
            this.title = title;
            this.contents = contents;
        }
    }
}
