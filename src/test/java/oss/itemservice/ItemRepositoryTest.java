package oss.itemservice;

import org.junit.jupiter.api.AfterEach;
import oss.itemservice.repository.ItemRepository;

public class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){ // 테스트 결과값을 남아있어서 제대로된 테스트하기가 싫어서 초기화하는 메서드 추가
        itemRepository.clearStore();
    }

}
