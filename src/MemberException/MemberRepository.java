package MemberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {
    private static final List<Member> memberList = new ArrayList<>();

    public void save(Member member) {
        memberList.add(member);
    }

    public Optional<Member> findByEmail(String email) {
        return memberList.stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }

    public Optional<Member> findById(Long id) {
        return memberList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(memberList); // 불변 컬렉션 방지용 복사본 리턴
    }
}
