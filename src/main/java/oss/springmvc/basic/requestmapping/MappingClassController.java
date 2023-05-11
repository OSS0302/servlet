package oss.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {
    /**
    회원 관리 API
    회원 목록 조회: GET /users
    회원 등록: POST   /users
    회원 조회: GET   /users/{userId}
    회원수정: PATCH /users/{userId}
     회원 삭제: DELETE /users/{userId}
    */
    @GetMapping("/mapping/users")
    public String uesrs(){ // 회원 목록조회
        return "get users";
    }
    @PostMapping("/mapping/users")
    public String addUser(){ // 회원 등록
        return "post user";
    }
    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId){ // 회원 조회(한명만 조회)
        return"get userId" + userId;
    }
    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable String userId){ // 회원 수정
        return"update userId" + userId;
    }



}
