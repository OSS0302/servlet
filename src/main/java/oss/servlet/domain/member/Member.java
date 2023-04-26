package oss.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id ; // 회원아이디
    private String username; //회원 이름
    private int age ; // 나이

    public Member() { // 기본생성자
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
