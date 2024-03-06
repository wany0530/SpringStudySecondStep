package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 *
 */
public class OrderServiceImpl implements OrderService
{
    private final MemberRepository memberRepository= new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //DIP 위반 이면서 Fix -> Rate 로 변경시 OCP 위반. 왜냐하면 수정(변경)했으니까ㅋ
    private DiscountPolicy discountPolicy; // DIP 위반 해결.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice)
    {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
