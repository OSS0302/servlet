package oss.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    private static Map<Long , Member> store = new HashMap();
    private static  long sequence =0L; //아이디 한개씩 증가 하는 시퀀스

    private static  final  MemberRepository instance = new MemberRepository();

    public static  MemberRepository getInstance(){
        return instance;
    }
    private  MemberRepository(){

    }
    public Member save(Member member){
        member.setId(++sequence); // 1씩 증가 해라
        store.put(member.getId(), member); //멤버 아이디를 넣어라
        return member; // member반환

    }
    public Member findById(Long id){
        return store.get(id); // 아이디로 찾겠다
    }
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //스토어 에있는 모든 값을 꺼내서 어레이 리스트에 넣는다.
    }
    public void clearStore() { // 테스트 할떄만 사용하며 스토어를 다 날린다.
        store.clear();
    }



}
