package HelloSpring.hellospring.service;

import HelloSpring.hellospring.domain.Member;
import HelloSpring.hellospring.repository.MemberRepository;
import HelloSpring.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    //회원가입
    public Long signUp(Member member){
        //중복회원x
        validDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateEx
                    ception("이미 존재하는 회원입니다.");
                });
    }
    
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
