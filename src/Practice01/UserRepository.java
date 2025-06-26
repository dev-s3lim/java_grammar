package Practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    /// 1. 회원 정보 저장 받을 리스트 준비
    static private List<User> userList = new ArrayList<>();

    /// 2. 회원 정보 저장 메서드
    public void save(User user) {
        userList.add(user);
    }

    /// 3. 회원 id 검색을 통한 회원정보 조회에 필요한 자료 제공을 해주는 메서드 (return)
    public Optional<User> searchById (Long id) {
        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    /// 4. 회원 email 검색을 통한 회원정보 조회에 필요한 자료 제공을 해주는 메서드 (return)
    public Optional<User> searchByEmail (String email) {
        return userList.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }

    /// 5. 전체 회원 정보 조회를 위한 자료를 리스트 형태로 제공하는 메서드 (return)\
    public List<User> searchAll() {
        return new ArrayList<>(userList);
    }
}