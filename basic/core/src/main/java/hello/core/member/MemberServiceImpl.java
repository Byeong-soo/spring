package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 의존관계가 인터페이스 뿐만아니라 구현체까지 의존하고 있음!! DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
