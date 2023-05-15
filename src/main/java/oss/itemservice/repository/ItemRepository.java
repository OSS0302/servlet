package oss.itemservice.repository;

import org.springframework.stereotype.Repository;
import oss.itemservice.domain.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    // 스프링안에 싱글톤 기본으로 세팅되어있어서 따로 static을 안써도된다.
    private static final Map<Long, Item> store = new HashMap<>(); //해쉬맵 동시성을 쓸수없어서 ConcurrentHashMap 를 사용해야한다.
    private static long squence = 0L; // static 이것또한 동시에 사용하면 안되서 오토밍 롱을 써야한다.

    public Item save(Item item){ // 아이템 저
        item.setId(++squence);// 아이디를 1씩 증가
        store.put(item.getId(),item); // 아이템을 넣어주고
        return item ; // 아이템 반환한다.
     }
     // 상품 조회
    public Item findById(Long id){
        return store.get(id);
    }
    // 상품전체 조회
    public List<Item> findAll(){
        return new ArrayList<>(store.values()); // 한번 감싸야지만 store에 영향을 주지 않는다.

    }
     public void update(Long itemId, Item updateParam){
         Item findItem = findById(itemId); // 아이디로 아이템을 찾는다.
         findItem.setItemName(updateParam.getItemName()); //아이템 이름
         findItem.setPriace(updateParam.getPriace()); //아이템 가격
         findItem.setQuantity(updateParam.getQuantity()); //아이템 갯수

     }
     public void clearStore(){
        store.clear();//여기있는 hashMap 이 초기화된다.
     }


}
