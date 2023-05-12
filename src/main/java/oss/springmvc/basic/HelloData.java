package oss.springmvc.basic;

import lombok.Data;

@Data//롬복 @Data@Getter , @Setter , @ToString , @EqualsAndHashCode , @RequiredArgsConstructor 를 자동으로 적용해준다.
public class HelloData {

    private String username; // 이름
    private int age; //나이


}
