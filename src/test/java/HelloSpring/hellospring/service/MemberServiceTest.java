package HelloSpring.hellospring.service;

import HelloSpring.hellospring.domain.Member;
import HelloSpring.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }
    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }
    @Test
    public void 회원가입(){
        //given(상황)
        Member member = new Member();
        member.setName("유저1");
        //when(언제)
        Long saveId = memberService.signUp(member);
        //then(결과)
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(result.getName());
    }
    @Test
    public void 중복회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("유저1");
        Member member2 = new Member();
        member2.setName("유저1");
        //when
        memberService.signUp(member1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.signUp(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    @Test
    void findMembers(){
    }
    @Test
    void findOne(){

    }
}
