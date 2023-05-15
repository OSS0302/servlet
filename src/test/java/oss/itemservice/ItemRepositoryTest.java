package oss.itemservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import oss.itemservice.domain.Item;
import oss.itemservice.repository.ItemRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){ // 테스트 결과값을 남아있어서 제대로된 테스트하기가 싫어서 초기화하는 메서드 추가
        itemRepository.clearStore();
    }
    @Test
    void save(){
        //given
        Item item =new Item("itemA",10000,10); //아이템이름:아이템A 가격: 10000 상품수량: 10개
        //when
        Item saveItem = itemRepository.save(item);
        //than
        Item findItem = itemRepository.findById(item.getId());
        //검증하기
        assertThat(findItem).isEqualTo(saveItem);
    }
    @Test
    void findAll(){
        //given
        Item item1 =new Item("itemA",10000,10); //아이템이름:아이템A 가격: 10000 상품수량: 10개
        Item item2 =new Item("itemA",10000,20); //아이템이름:아이템B 가격: 20000 상품수량: 20개
        // 아이템 저장하기
        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> result = itemRepository.findAll();

        //than
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1,item2);
    }
    @Test
    void updateItem (){
        //given
        Item item1 =new Item("itemA",10000,10); //아이템이름:아이템A 가격: 10000 상품수량: 10개
        Item item2 =new Item("itemA",10000,20); //아이템이름:아이템B 가격: 20000 상품수량: 20개
        // 아이템 저장하기
        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        //than

    }
}
