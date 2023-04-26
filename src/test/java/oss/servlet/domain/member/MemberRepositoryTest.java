package oss.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    // 테스트를 초기화 하기 위해서 사용한다.
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void  save(){
        //given 이런걸 주어졌을때
        Member member = new Member("hello", 20);
        //when 이런걸 실행했을떄
        Member savedMember = memberRepository.save(member);
        //than 이런걸 결과값
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }


}