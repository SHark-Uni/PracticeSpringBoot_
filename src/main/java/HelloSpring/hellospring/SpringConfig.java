package HelloSpring.hellospring;

import HelloSpring.hellospring.repository.MemberRepository;
import HelloSpring.hellospring.repository.MemoryMemberRepository;
import HelloSpring.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberSerivce(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
