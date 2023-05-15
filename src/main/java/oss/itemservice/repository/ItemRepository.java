package oss.itemservice.repository;

import org.springframework.stereotype.Repository;
import oss.itemservice.domain.Item;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    // 스프링안에 싱글톤 기본으로 세팅되어있어서 따로 static을 안써도된다.
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long squence = 0L; // static

    public Item save(Item item){ // 아이템 저장
        item.setId(++squence);// 아이디를 1씩 증가
        store.put(item.getId(),item); // 아이템을 넣어주고
        return item ; // 아이템 반환한다.
     }

}
