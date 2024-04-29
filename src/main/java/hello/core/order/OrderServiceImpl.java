package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 */

@Component
//@RequiredArgsConstructor //final이 붙은 클래스변수를 기준으로 생성자를 만들어 줌.
public class OrderServiceImpl implements OrderService
{
//    private MemberRepository memberRepository= new MemoryMemberRepository(); //DIP 위반
    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //DIP 위반 이면서 Fix -> Rate 로 변경시 OCP 위반. 왜냐하면 수정(변경)했으니까ㅋ
    private final  DiscountPolicy discountPolicy; // DIP 위반 해결.

    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy")DiscountPolicy discountPolicy)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy)
    {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice)
    {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository  getMemberRepository()
    {
        return memberRepository;
    }
}
