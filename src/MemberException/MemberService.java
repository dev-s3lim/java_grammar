package MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MemberService {
    private final MemberRepository repository;

    public MemberService() {
        this.repository = new MemberRepository();
    }

    public void register(String name, String email, String password) {
        if (repository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 등록된 이메일입니다.");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상이어야 합니다.");
        }

        repository.save(new Member(name, email, password));
    }

    public Member findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }

    public List<Member> findAll() {
        return repository.findAll();
    }

    public void login(String email, String password) {
        Member member = repository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("이메일이 존재하지 않습니다."));
        if (!member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}