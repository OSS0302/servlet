package oss.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

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

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }


}