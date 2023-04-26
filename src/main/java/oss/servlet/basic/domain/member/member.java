package oss.servlet.basic.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class member {
    private long id; // 회원 아이디
    private String username; //유저 이름
    private int age; // 유저이름

    public member(){} // 기본생성자

    public member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
