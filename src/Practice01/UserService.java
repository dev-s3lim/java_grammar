package Practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    /// 1. 핵심 로직들이 참조 및 사용할 회원 DB 객체 준비
    private final UserRepository repository;

    /// 2. 해당 DB 객체는 매번 서비스 클래스의 메서드가 호출될 때마다 새롭게 초기화 될 것이란 것을 선언
    public UserService () {
        this.repository = new UserRepository();
    }

    /// 3. 회원가입 메서드 (이미 가입된 이메일이 있거나, 비밀번호가 8자리 이하라면 예외처리)
    public void registration (String name, String email, String password) {
        if (repository.returnEmail(email).isPresent()) {
            throw new IllegalArgumentException("!!!이미 가입에 사용된 이메일입니다.!!!");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("!!!비밀번호는 최소 8자리 이상입니다.!!!");
        }

        repository.saveInfo(new User(name, email, password));
    }

    /// 4. id로 회원 상세조회 하는 메서드 (잘못 입력하였을 시 예외처리)
    public User searchById (Long id) {
        return repository.returnId(id)
                .orElseThrow(() -> new NoSuchElementException("!!!존재하지 않는 ID입니다.!!!"));
    }

    /// 5. email로 회원 상세조회 하는 메서드 (잘못 입력하였을 시 예외처리)
    public User searchByEmail (String email) {
        return repository.returnEmail(email)
                .orElseThrow(() -> new NoSuchElementException("!!!존재하지 않는 이메일입니다.!!!"));
    }

    /// 6. 전체 회원을 조회하는 메서드
    public List<User> searchAll () {
        return repository.returnAllInfo();
    }

    /// 7. 로그인 메서드
    public User login (String email, String password) {
        User user = repository.returnEmail(email)
                .orElseThrow(() -> new NoSuchElementException("!!!존재하지 않는 계정입니다.!!!"));
        if(!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("!!!비밀번호가 일치하지 않습니다.!!!");
        }

        return user;
    }
}