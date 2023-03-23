package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //  위에서 확인한 memberService와 실제 MemberService.class가 같은 것인지 확인하기
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    public void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImp.class);

        //  위에서 확인한 memberService와 실제 MemberService.class가 같은 것인지 확인하기
        assertThat(memberService).isInstanceOf(MemberServiceImp.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByNameX(){
        // ac.getBean("xxxx", MemberService.class)
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("xxxx", MemberService.class) );
    }
}
