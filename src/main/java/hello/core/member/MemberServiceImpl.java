package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService
{
//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //DIP 위반
    private MemberRepository memberRepository;

    @Autowired //@Autowired는 이전에 테스트에서 했던 ac.getBean(MemberRepository.class)을 쓸수가있다. 즉 자동 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member)
    {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId)
    {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository()
    {
        return memberRepository;
    }
}
