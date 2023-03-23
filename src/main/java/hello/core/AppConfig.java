package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImp;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//		return new FIxDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImp( memberRepository() );
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImp( memberRepository(), discountPolicy() );
    }

}
